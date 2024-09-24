import java.util.*;
import java.util.Stack;

public class StackAppMain {

    public static boolean isOperand(char ch){
        return ( ( ch >= 65 && ch <= 90 ) || ( ch >= 97 && ch <= 122 ) || ( ch >= 48 && ch <= 57 ) );
    }

    //in priority() function we are defining priority for operators programmatically
    public static int priority(char opr){
        switch( opr ){

            case '(': return 0;
            
            case '+':
            case '-': return 1;

            case '%':
            case '*':
            case '/': return 2;

            default : return -1;
        }
    }

    /*
    //non-parenthesized:
    public static String infixToPostfix(String infix){
        //initially we need to take an empty stack of an operators
        Stack<Character> s = new Stack<Character>();
        StringBuilder postfix = new StringBuilder();

        //step-1: start scanning infix expression from left to right
        for( int index = 0 ; index < infix.length() ; index++ ){
            //get ele at cur index
            char cur_ele = infix.charAt(index);

            //step-2: if( cur ele is an operand ) => append it into the postfix expression
            if( isOperand(cur_ele) )
                postfix.append(cur_ele);
            else{//step-3: if cur ele is an operator

                //if stack is not empty && priority(topmost ele) >= priority( cur_ele) 
                while( ! s.empty() && priority( s.peek() ) >= priority( cur_ele ) ){
                    //pop ele from the stack and append it into the postfix expression
                    postfix.append( s.peek() );
                    s.pop();
                }

                //push cur ele onto the stack
                s.push(cur_ele);
            }
        }//step-4: repeat step-2 & step-3 till the end of infix expression
        
        //step-5: pop all remaining ele's from the stack and append them into the postfix expression
        while( ! s.empty() ){//till stack not becomes empty
            postfix.append( s.peek() );
            s.pop();
        }

        //convert StringBuilder class object into String class object and then return it to the calling fuction
        return ( postfix.toString() );
    }
    */

    //parenthesized as well non-parenthesized:
    public static String infixToPostfix(String infix){
        //initially we need to take an empty stack of an operators
        Stack<Character> s = new Stack<Character>();
        StringBuilder postfix = new StringBuilder();

        //step-1: start scanning infix expression from left to right
        for( int index = 0 ; index < infix.length() ; index++ ){
            //get ele at cur index
            char cur_ele = infix.charAt(index);

            //step-2: if( cur ele is an operand ) => append it into the postfix expression
            if( isOperand(cur_ele) )
                postfix.append(cur_ele);
            else if( cur_ele == '(' )//if cur ele is an opening brace -> push it onto the stack
                s.push(cur_ele);
            else if( cur_ele == ')' ){//if cur ele is an closing brace
                //pop ele's from the stack and append them into the postfix expression till its corresponding opening brace do not occurs
                while( s.peek() != '(' ){
                    postfix.append(s.peek() );
                    s.pop();
                }
                
                //pop opening brace from the stack and discard both opening brace and closing brace
                s.pop();
            }else{//step-3: if cur ele is an operator

                //if stack is not empty && priority(topmost ele) >= priority( cur_ele) 
                while( ! s.empty() && priority( s.peek() ) >= priority( cur_ele ) ){
                    //pop ele from the stack and append it into the postfix expression
                    postfix.append( s.peek() );
                    s.pop();
                }

                //push cur ele onto the stack
                s.push(cur_ele);
            }
        }//step-4: repeat step-2 & step-3 till the end of infix expression
        
        //step-5: pop all remaining ele's from the stack and append them into the postfix expression
        while( ! s.empty() ){//till stack not becomes empty
            postfix.append( s.peek() );
            s.pop();
        }

        //convert StringBuilder class object into String class object and then return it to the calling fuction
        return ( postfix.toString() );
    }

    public static String infixToPrefix(String infix){
        //initially we need to take an empty stack of an operators
        Stack<Character> s = new Stack<Character>();
        StringBuilder prefix = new StringBuilder();

        //step-1: start scanning infix expression from right to left
        for( int index = infix.length()-1 ; index >= 0 ; index-- ){
            //get ele at cur index
            char cur_ele = infix.charAt(index);

            //step-2: if( cur ele is an operand ) => append it into the prefix expression
            if( isOperand(cur_ele) )
                prefix.append(cur_ele);
            else{//step-3: if cur ele is an operator

                //if stack is not empty && priority(topmost ele) > priority( cur_ele) 
                while( ! s.empty() && priority( s.peek() ) > priority( cur_ele ) ){
                    //pop ele from the stack and append it into the prefix expression
                    prefix.append( s.peek() );
                    s.pop();
                }

                //push cur ele onto the stack
                s.push(cur_ele);
            }
        }//step-4: repeat step-2 & step-3 till the end of infix expression
        
        //step-5: pop all remaining ele's from the stack and append them into the prefix expression
        while( ! s.empty() ){//till stack not becomes empty
            prefix.append( s.peek() );
            s.pop();
        }

        //step-6: reverse prefix expression, convert StringBuilder class object into String class object and then return it to the calling fuction
        return ( prefix.reverse().toString() );
    }


    public static int calculate(int op1, int op2, char opr){
        switch( opr ){
            case  '+': return ( op1 + op2 );
            case  '-': return ( op1 - op2 );
            case  '*': return ( op1 * op2 );
            case  '/': return ( op1 / op2 );
            case  '%': return ( op1 % op2 );

            default: return -1;
        }
    }

    public static int postfixEvaluation(String postfix){
        //initially stack of operands is empty
        Stack<Integer> s = new Stack<Integer>();
        int result;

        //step-1: start scanning postfix expression from left to right
        for( int index = 0 ; index < postfix.length() ; index++ ){
            char cur_ele = postfix.charAt(index);

            //step-2: if( cur ele is an operand ) => push it onto the stack
            if( isOperand(cur_ele) ){
                s.push( cur_ele - '0' );//as we need to push int equivalent of cur ele of type char
            }else{//if cur ele is an "opr" i.e. operator
                //- pop two ele'/openrands from the stack in such a way
                //first popped ele will be second operand
                int op2 = s.peek(); s.pop();
                //second popped ele will be first operand
                int op1 = s.peek(); s.pop();

                //perform cur ele (opr) operation between op1 & op2
                result = calculate(op1, op2, cur_ele);
                //push back result onto the stack
                s.push(result);
            }
        }//end of for loop
        //step-3: pop final result from the stack
        result = s.peek();
        s.pop();
        return result;
    }
    

    public static void main(String[] args) {
        //String infix = "a*b/c*d+e-f*g+h";
        //String infix = "((a+b)/(c*d)+e)-f*g+h";
        String infix = "4+5*9/7+3-6";

        System.out.println("infix expression is : "+infix);
        
        String postfix = infixToPostfix(infix);
        //String prefix = infixToPrefix(infix);
        
        System.out.println("postfix expression is : "+postfix);
        //System.out.println("prefix expression is : "+prefix);
        System.out.println("result : "+postfixEvaluation(postfix) );

    }
}
