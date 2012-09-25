// $ANTLR 3.4 /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g 2012-09-25 16:15:17

package com.github.seqware.queryengine.kernel;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class SeqWareQueryLanguageLexer extends Lexer {
    public static final int EOF=-1;
    public static final int AND=4;
    public static final int BRACKET_CLOSE=5;
    public static final int BRACKET_OPEN=6;
    public static final int COMMENT_EOL=7;
    public static final int COMMENT_INLINE=8;
    public static final int EQUALS=9;
    public static final int FLOAT=10;
    public static final int GT=11;
    public static final int GTEQ=12;
    public static final int ID=13;
    public static final int INT=14;
    public static final int LT=15;
    public static final int LTEQ=16;
    public static final int NAMED_CONSTANT=17;
    public static final int NAMED_FUNCTION=18;
    public static final int NOTEQUALS=19;
    public static final int OR=20;
    public static final int STRING=21;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public SeqWareQueryLanguageLexer() {} 
    public SeqWareQueryLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SeqWareQueryLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g"; }

    // $ANTLR start "NAMED_CONSTANT"
    public final void mNAMED_CONSTANT() throws RecognitionException {
        try {
            int _type = NAMED_CONSTANT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:70:2: ( 'STRAND_UNKNOWN' | 'NOT_STRANDED' | 'NEGATIVE_STRAND' | 'POSITIVE_STRAND' )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 'S':
                {
                alt1=1;
                }
                break;
            case 'N':
                {
                int LA1_2 = input.LA(2);

                if ( (LA1_2=='O') ) {
                    alt1=2;
                }
                else if ( (LA1_2=='E') ) {
                    alt1=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 2, input);

                    throw nvae;

                }
                }
                break;
            case 'P':
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }

            switch (alt1) {
                case 1 :
                    // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:70:4: 'STRAND_UNKNOWN'
                    {
                    match("STRAND_UNKNOWN"); 



                    }
                    break;
                case 2 :
                    // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:70:23: 'NOT_STRANDED'
                    {
                    match("NOT_STRANDED"); 



                    }
                    break;
                case 3 :
                    // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:70:40: 'NEGATIVE_STRAND'
                    {
                    match("NEGATIVE_STRAND"); 



                    }
                    break;
                case 4 :
                    // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:70:60: 'POSITIVE_STRAND'
                    {
                    match("POSITIVE_STRAND"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NAMED_CONSTANT"

    // $ANTLR start "NAMED_FUNCTION"
    public final void mNAMED_FUNCTION() throws RecognitionException {
        try {
            int _type = NAMED_FUNCTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:74:2: ( 'tagOccurrence' | 'tagHierarchicalOccurrence' | 'tagValuePresence' )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='t') ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1=='a') ) {
                    int LA2_2 = input.LA(3);

                    if ( (LA2_2=='g') ) {
                        switch ( input.LA(4) ) {
                        case 'O':
                            {
                            alt2=1;
                            }
                            break;
                        case 'H':
                            {
                            alt2=2;
                            }
                            break;
                        case 'V':
                            {
                            alt2=3;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 2, 3, input);

                            throw nvae;

                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 2, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:74:4: 'tagOccurrence'
                    {
                    match("tagOccurrence"); 



                    }
                    break;
                case 2 :
                    // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:74:22: 'tagHierarchicalOccurrence'
                    {
                    match("tagHierarchicalOccurrence"); 



                    }
                    break;
                case 3 :
                    // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:74:52: 'tagValuePresence'
                    {
                    match("tagValuePresence"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NAMED_FUNCTION"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:78:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:78:4: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:78:28: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||LA3_0=='_'||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:82:2: ( ( '0' .. '9' )+ )
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:82:4: ( '0' .. '9' )+
            {
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:82:4: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:86:6: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* | '.' ( '0' .. '9' )+ )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
                alt8=1;
            }
            else if ( (LA8_0=='.') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:86:8: ( '0' .. '9' )+ '.' ( '0' .. '9' )*
                    {
                    // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:86:8: ( '0' .. '9' )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);


                    match('.'); 

                    // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:86:24: ( '0' .. '9' )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:87:8: '.' ( '0' .. '9' )+
                    {
                    match('.'); 

                    // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:87:12: ( '0' .. '9' )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "COMMENT_EOL"
    public final void mCOMMENT_EOL() throws RecognitionException {
        try {
            int _type = COMMENT_EOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:91:2: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:91:4: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 



            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:91:9: (~ ( '\\n' | '\\r' ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0 >= '\u0000' && LA9_0 <= '\t')||(LA9_0 >= '\u000B' && LA9_0 <= '\f')||(LA9_0 >= '\u000E' && LA9_0 <= '\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:91:23: ( '\\r' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:91:23: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }


            match('\n'); 

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT_EOL"

    // $ANTLR start "COMMENT_INLINE"
    public final void mCOMMENT_INLINE() throws RecognitionException {
        try {
            int _type = COMMENT_INLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:95:2: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:95:4: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 



            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:95:9: ( options {greedy=false; } : . )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='*') ) {
                    int LA11_1 = input.LA(2);

                    if ( (LA11_1=='/') ) {
                        alt11=2;
                    }
                    else if ( ((LA11_1 >= '\u0000' && LA11_1 <= '.')||(LA11_1 >= '0' && LA11_1 <= '\uFFFF')) ) {
                        alt11=1;
                    }


                }
                else if ( ((LA11_0 >= '\u0000' && LA11_0 <= ')')||(LA11_0 >= '+' && LA11_0 <= '\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:95:37: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            match("*/"); 



            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT_INLINE"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:99:5: ( '\"' (~ ( '\\\\' | '\"' ) )* '\"' )
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:99:8: '\"' (~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 

            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:99:12: (~ ( '\\\\' | '\"' ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0 >= '\u0000' && LA12_0 <= '!')||(LA12_0 >= '#' && LA12_0 <= '[')||(LA12_0 >= ']' && LA12_0 <= '\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:103:2: ( '||' )
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:103:4: '||'
            {
            match("||"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:107:2: ( '&&' )
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:107:4: '&&'
            {
            match("&&"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "EQUALS"
    public final void mEQUALS() throws RecognitionException {
        try {
            int _type = EQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:111:2: ( '==' )
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:111:4: '=='
            {
            match("=="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EQUALS"

    // $ANTLR start "NOTEQUALS"
    public final void mNOTEQUALS() throws RecognitionException {
        try {
            int _type = NOTEQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:115:2: ( '!=' )
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:115:4: '!='
            {
            match("!="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOTEQUALS"

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:119:2: ( '<' )
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:119:4: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LT"

    // $ANTLR start "LTEQ"
    public final void mLTEQ() throws RecognitionException {
        try {
            int _type = LTEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:123:2: ( '<=' )
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:123:4: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LTEQ"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:127:2: ( '>' )
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:127:4: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GT"

    // $ANTLR start "GTEQ"
    public final void mGTEQ() throws RecognitionException {
        try {
            int _type = GTEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:131:2: ( '>=' )
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:131:4: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GTEQ"

    // $ANTLR start "BRACKET_OPEN"
    public final void mBRACKET_OPEN() throws RecognitionException {
        try {
            int _type = BRACKET_OPEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:135:2: ( '(' )
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:135:4: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BRACKET_OPEN"

    // $ANTLR start "BRACKET_CLOSE"
    public final void mBRACKET_CLOSE() throws RecognitionException {
        try {
            int _type = BRACKET_CLOSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:139:2: ( ')' )
            // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:139:4: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BRACKET_CLOSE"

    public void mTokens() throws RecognitionException {
        // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:1:8: ( NAMED_CONSTANT | NAMED_FUNCTION | ID | INT | FLOAT | COMMENT_EOL | COMMENT_INLINE | STRING | OR | AND | EQUALS | NOTEQUALS | LT | LTEQ | GT | GTEQ | BRACKET_OPEN | BRACKET_CLOSE )
        int alt13=18;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:1:10: NAMED_CONSTANT
                {
                mNAMED_CONSTANT(); 


                }
                break;
            case 2 :
                // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:1:25: NAMED_FUNCTION
                {
                mNAMED_FUNCTION(); 


                }
                break;
            case 3 :
                // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:1:40: ID
                {
                mID(); 


                }
                break;
            case 4 :
                // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:1:43: INT
                {
                mINT(); 


                }
                break;
            case 5 :
                // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:1:47: FLOAT
                {
                mFLOAT(); 


                }
                break;
            case 6 :
                // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:1:53: COMMENT_EOL
                {
                mCOMMENT_EOL(); 


                }
                break;
            case 7 :
                // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:1:65: COMMENT_INLINE
                {
                mCOMMENT_INLINE(); 


                }
                break;
            case 8 :
                // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:1:80: STRING
                {
                mSTRING(); 


                }
                break;
            case 9 :
                // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:1:87: OR
                {
                mOR(); 


                }
                break;
            case 10 :
                // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:1:90: AND
                {
                mAND(); 


                }
                break;
            case 11 :
                // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:1:94: EQUALS
                {
                mEQUALS(); 


                }
                break;
            case 12 :
                // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:1:101: NOTEQUALS
                {
                mNOTEQUALS(); 


                }
                break;
            case 13 :
                // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:1:111: LT
                {
                mLT(); 


                }
                break;
            case 14 :
                // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:1:114: LTEQ
                {
                mLTEQ(); 


                }
                break;
            case 15 :
                // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:1:119: GT
                {
                mGT(); 


                }
                break;
            case 16 :
                // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:1:122: GTEQ
                {
                mGTEQ(); 


                }
                break;
            case 17 :
                // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:1:127: BRACKET_OPEN
                {
                mBRACKET_OPEN(); 


                }
                break;
            case 18 :
                // /Users/jbaran/src/seqware/seqware-queryengine/src/main/java/com/github/seqware/queryengine/kernel/SeqWareQueryLanguage.g:1:140: BRACKET_CLOSE
                {
                mBRACKET_CLOSE(); 


                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\1\uffff\4\5\1\uffff\1\27\7\uffff\1\33\1\35\2\uffff\5\5\7\uffff"+
        "\76\5\1\143\6\5\1\uffff\2\5\1\154\2\5\1\143\2\5\1\uffff\2\5\2\143"+
        "\3\5\1\154\10\5\1\154";
    static final String DFA13_eofS =
        "\176\uffff";
    static final String DFA13_minS =
        "\1\41\1\124\1\105\1\117\1\141\1\uffff\1\56\1\uffff\1\52\5\uffff"+
        "\2\75\2\uffff\1\122\1\124\1\107\1\123\1\147\7\uffff\1\101\1\137"+
        "\1\101\1\111\1\110\1\116\1\123\2\124\1\143\1\151\1\141\1\104\1\124"+
        "\2\111\1\143\1\145\1\154\1\137\1\122\2\126\1\165\1\162\1\165\1\125"+
        "\1\101\2\105\1\162\1\141\1\145\2\116\2\137\2\162\1\120\1\113\1\104"+
        "\2\123\1\145\1\143\1\162\1\116\1\105\2\124\1\156\1\150\1\145\1\117"+
        "\1\104\2\122\1\143\1\151\1\163\1\127\1\60\2\101\1\145\1\143\1\145"+
        "\1\116\1\uffff\2\116\1\60\1\141\1\156\1\60\2\104\1\uffff\1\154\1"+
        "\143\2\60\1\117\1\145\1\143\1\60\1\143\1\165\2\162\1\145\1\156\1"+
        "\143\1\145\1\60";
    static final String DFA13_maxS =
        "\1\174\1\124\2\117\1\141\1\uffff\1\71\1\uffff\1\57\5\uffff\2\75"+
        "\2\uffff\1\122\1\124\1\107\1\123\1\147\7\uffff\1\101\1\137\1\101"+
        "\1\111\1\126\1\116\1\123\2\124\1\143\1\151\1\141\1\104\1\124\2\111"+
        "\1\143\1\145\1\154\1\137\1\122\2\126\1\165\1\162\1\165\1\125\1\101"+
        "\2\105\1\162\1\141\1\145\2\116\2\137\2\162\1\120\1\113\1\104\2\123"+
        "\1\145\1\143\1\162\1\116\1\105\2\124\1\156\1\150\1\145\1\117\1\104"+
        "\2\122\1\143\1\151\1\163\1\127\1\172\2\101\1\145\1\143\1\145\1\116"+
        "\1\uffff\2\116\1\172\1\141\1\156\1\172\2\104\1\uffff\1\154\1\143"+
        "\2\172\1\117\1\145\1\143\1\172\1\143\1\165\2\162\1\145\1\156\1\143"+
        "\1\145\1\172";
    static final String DFA13_acceptS =
        "\5\uffff\1\3\1\uffff\1\5\1\uffff\1\10\1\11\1\12\1\13\1\14\2\uffff"+
        "\1\21\1\22\5\uffff\1\4\1\6\1\7\1\16\1\15\1\20\1\17\105\uffff\1\1"+
        "\10\uffff\1\2\21\uffff";
    static final String DFA13_specialS =
        "\176\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\15\1\11\3\uffff\1\13\1\uffff\1\20\1\21\4\uffff\1\7\1\10\12"+
            "\6\2\uffff\1\16\1\14\1\17\2\uffff\15\5\1\2\1\5\1\3\2\5\1\1\7"+
            "\5\4\uffff\1\5\1\uffff\23\5\1\4\6\5\1\uffff\1\12",
            "\1\22",
            "\1\24\11\uffff\1\23",
            "\1\25",
            "\1\26",
            "",
            "\1\7\1\uffff\12\6",
            "",
            "\1\31\4\uffff\1\30",
            "",
            "",
            "",
            "",
            "",
            "\1\32",
            "\1\34",
            "",
            "",
            "\1\36",
            "\1\37",
            "\1\40",
            "\1\41",
            "\1\42",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\50\6\uffff\1\47\6\uffff\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\12\5\7\uffff\32\5\4\uffff\1\5\1\uffff\32\5",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "",
            "\1\152",
            "\1\153",
            "\12\5\7\uffff\32\5\4\uffff\1\5\1\uffff\32\5",
            "\1\155",
            "\1\156",
            "\12\5\7\uffff\32\5\4\uffff\1\5\1\uffff\32\5",
            "\1\157",
            "\1\160",
            "",
            "\1\161",
            "\1\162",
            "\12\5\7\uffff\32\5\4\uffff\1\5\1\uffff\32\5",
            "\12\5\7\uffff\32\5\4\uffff\1\5\1\uffff\32\5",
            "\1\163",
            "\1\164",
            "\1\165",
            "\12\5\7\uffff\32\5\4\uffff\1\5\1\uffff\32\5",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\12\5\7\uffff\32\5\4\uffff\1\5\1\uffff\32\5"
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( NAMED_CONSTANT | NAMED_FUNCTION | ID | INT | FLOAT | COMMENT_EOL | COMMENT_INLINE | STRING | OR | AND | EQUALS | NOTEQUALS | LT | LTEQ | GT | GTEQ | BRACKET_OPEN | BRACKET_CLOSE );";
        }
    }
 

}