---

title:                 "SeqWare Web Service"
toc_includes_sections: true
markdown:              advanced
is_dynamic: true

---


## Overview

The purpose of the Web service in SeqWare is threefold. First, it allows
individuals to connect to the database with user-specific permissions. Second,
it prevents direct access to the database. Third, it allows remote users to
query the database without needing to install the PostgreSQL client locally. 

In the first case, not all users should be able to access all studies in the
MetadataDB. Some studies have proprietary information that should not be widely
available. PostgreSQL cannot grant row-specific permissions for users.
Authentication through the Web Service will allow those users to view and
change only those rows that they have permission to view.

Secondly, direct access to the database should be discouraged. There is a great
deal of business logic built into SeqWare that is not available at the database
level. The database allows for much more flexibility than SeqWare Pipeline
expects. Therefore it is advisable to redirect all database queries through a
business logic layer that will preserve the hierarchy in the database.

Thirdly, remote users can query the database without having to construct an SQL
query and without needing to install the PostgreSQL client. We are using a
RESTful Web service, in which most of the information needed by the Web service
is provided in the HTTP URL and the message type. For example, navigating to
/seqware-webservice-0.10.0/workflows is equivalent to 'SELECT * FROM workflow;'
in psql, and going to /seqware-webservice-0.10.0/workflows/1 is equivalent to
'SELECT * FROM workflow WHERE sw_accession = 1;'. These queries may be executed
either in a browser or programmatically.

## Configuration

If you are working on our CentOS VM from the [Installation](/docs/2-installation/) guide
your settings file will already be present. Otherwise, your SeqWare settings
file needs to be configured to use the Web service rather than 'database' or
'nometadata'. This file is usually located at ~/.seqware/settings.

There are four variables that need to be changed: <tt>SW_METADATA_METHOD</tt>,
<tt>SW_REST_URL</tt>, <tt>SW_REST_USER</tt>, and <tt>SW_REST_PASS</tt>. The
<tt>SW_REST_URL</tt> is the location of the deployed WebService. Below is an
example snippet of a .seqware/settings file.

	SW_METADATA_METHOD=webservice
	SW_REST_URL=http://localhost:8080/seqware-webservice-<%= seqware_release_version %>
	SW_REST_USER=admin@admin.com
	SW_REST_PASS=admin

## Using the Web Service
 
Providing the Web service is already installed for you, there are three
approaches to using the Web service. In order from least to most programming,
these are the options:

* **Use SeqWare Pipeline with the Web service enabled:** The only configuration necessary is to change your .seqware/settings file to point to the Web service. The seqware-distribution jar will use the Web service instead of a direct database connection with no further changes. This is how you access the command line-based reporting tools.
* **Use the Java API**: When writing SeqWare plugins or workflow modules, you can access the Webservice through the Metadata object. This object gives you more direct control while hiding the business logic. For example, you can install a new workflow, create processing events, and schedule workflow runs programmatically through this system.
* **Script to the Web service directly**: Which would involve sending HTTP requests to the RESTful URLs and processing the response. Simple queries can also be entered directly into your browser, which will return XML describing the object. For example, you can get an XML representation of all of the studies in the database by going to http://localhost:8080/seqware-webservice-<%= seqware_release_version %>/studies. Very little business logic is built into the Web service directly. The exception to this is [Running workflows through the Web service](/docs/23-running-workflows-via-web-service/) for more details.

The .seqware/settings file needs to be configured to use the Web service for the first two options. In the third option, you must provide the URL, username and password yourself.

## Building and Installing

Most users will want to use our pre-configured VMs, see the [SeqWare Install
Guide](/docs/2-installation/) for how to get the VM.  The SeqWare Web service
is the primary mechanism by which users can reach the SeqWare MetaDB. The Web
service prevents the user from having to make SQL queries and facilitates
building services on top of the MetaDB. Currently, there is a Java client
located in the seqware-commons package that can be used to access the
WebService, which is configured through the .seqware/settings file.

Please see the [Install Guide](/docs/github_readme/4-webservice/)

## Web Service API

This API describes the resources that make up the SeqWare RESTful Web service. 

The SeqWare Web service has two primary functions. First, it is the primary
mechanism by which users can query the SeqWare MetaDB. The Web service prevents
the user from having to make SQL queries and facilitates building services on
top of the MetaDB. Secondly, it allows privileged users to launch and monitor
next-generation sequencing workflows and pipelines remotely without having any
local SeqWare dependencies. These two functions are split into 'Metadata' and
'Pipeline' functions.

### Metadata Resources

Operations on the metadata resources are primarily for read-only access of the
SeqWare metadata database. Any PUT or POST operations add only one row to one
table in the SeqWare Metadata database. There are four classifications of
resources:

* [Data](/docs/webservice-api/metadata/db/) - Resources that adds, retrieves or updates one or more rows from a database table.
* [Reports](/docs/webservice-api/metadata/report/) - Resources that query the state of the Metadata DB and amalgamate information from multiple database tables in order to report on the state of a study, sequencer run, sample, etc. 
* [Jobs](/docs/webservice-api/metadata/job/) - Resources that cause considerable processing on the server side and include PUT and POST operations.
* [Experimental](/docs/webservice-api/metadata/x/) - Resources that are in development or in a testing phase.  

### Pipeline Resources

These jobs loosely correspond with tasks performed by SeqWare Pipeline, for
example, launching workflows, modules, and plugins. Pipeline tasks are
distinguished from Metadata tasks because they trigger more advanced processing
of the data by systems other than those associated with the Metadata DB. For
example, jobs triggered on the pipeline may cause a job to be run on a server,
or a ZIP file to be uploaded and installed as a workflow.

At the moment, a workflow can be launched through a [job](/docs/webservice-api/pipeline/job/) resource.

## See Also

The [reporting](/docs/6-pipeline/#reporting) section of the Pipeline
documentation includes information on various reporting tools built on top of
the Web Service. Most users will be interested in using these command line
tools directly since they greatly simplify the process of querying the web
service for retrieving workflow results.

<!-- 

## Coming Soon ##

*This guide is a work in progress.* In the future this will include more information on the following topics.

### Admin Setup

See the [Admin Guide](/docs/3-getting-started/admin-tutorial/)

### Features

### Reporting

### Workflow Launching, Monitoring

### Data Retrieval


-->

