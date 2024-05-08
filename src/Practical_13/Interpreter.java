package Practical_13;
//class Talk is part of practical 13 package
import java.util.EmptyStackException;
//this library is runtime exception that returns a boolean based on whether a stack is empty or not
import java.util.Stack;
//the Stack library imports all functions that allows to interact with stack objects
import java.text.DecimalFormat;
//the Decimal format library is imported



//this class is responsible for containing all methods that work together to solve a post fix notation
//each object of Interpreter can solve one post fix expression
public class Interpreter {

    //the stack variable that is a Stack of type string is declared
    private Stack<String> stack;

    //decimal format object is created, and it has a format of 2dp
    //all instances of the Interpreter objects can use the decimal format
    private DecimalFormat decimalFormat = new DecimalFormat("#.##");

    //the constructor take in no arguments and instantiates the stack, and it has no string items in it
    public Interpreter(){
        stack = new Stack<String>();
    }
    //the above

    //this method accepts the post fix notation expression written by the user
    //also this method is mostly responsible for leading the process of solving the post fix notation
    public void calculate_post_fix_expression(String expression){

        //the expression list of type String list contains all the
        //symbols(operands and operators) within the post fix expression are
        //separated and added to the expression list based on the space separations
        String[] expression_list = expression.split("\\s+");
        //this for loop goes through every symbol item in the expression list
        for(String symbol : expression_list){
            //if the symbol is an operator
            //the isOperator is called with the symbol as the argument value
            if(isOperator(symbol)){
                //then the symbol is pushed onto the stack
                stack.push(symbol);

                //the following output is describing how rule 1 is implemented
                //in the current scenario
                System.out.println("Rule 1: Operand("+symbol+") := "+
                        symbol);
                //then the current stack after having the operator pushed is displayed
                System.out.println("\tStack: "+stack);
                //then the method useOperator is called as the operator symbol is passed as the argument
                useOperator(symbol);
                //after the method has been executed the new stack is displayed
                System.out.println("\tStack: "+stack);
            }
            //otherwise if the symbol is a numeric value
            else if(isOperand(symbol)){
                //teh double type value is pushed onto the stack
                stack.push(symbol);
                //and the new stack is displayed
                System.out.println("\tStack: "+stack);
            }

            //in other case the symbol is neither an operator or an operand
            //this means that the user entered an invalid input in the post fix expression
            else{
                //the invalid symbol is displayed to the user
                System.out.println("invalid input "+symbol+
                        " is not acceptable");
                //the program stops
                System.exit(0);
            }

        }
        //finally the number of items in the stack is checked
        //if the stack has more than one item left inside
        if(stack.size() > 1){
            //then the user must have entered an incorrect post fix notation expression
            System.out.println("The above stack ended with multiple operands" +
                    " please check the input and make changes");
        }
        //otherwise the post fix notation calculation was successful and the user entered a valid input
        else {
            //also the final result is displayed
            //and the stack is back to being empty
            System.out.println("Final result: " + stack.pop());
        }
    }


    //this method checks if the given symbol is and operator
    //the operator is passed as a string
    public boolean isOperator(String operator){
        //then a boolean value is returned if the symbol is either +, -, *, /
        return(operator.equals("+") || operator.equals("-") ||
                operator.equals("*") || operator.equals("/"));
    }


    //this method checks is the symbol is an operand
    //the symbol is passed through as an operand
    public boolean isOperand(String operand){

        //below is the try exception block
        try{
            //the operand that is a string is converted into a Double type
            //without storing it
            Double.parseDouble(operand);
        }
        //if unsuccessful then the error produced will beNumberFormatException
        catch(NumberFormatException e){
            //boolean false is returned
            return false;
        }
        //otherwise if there was no error with data type conversion
        //Rule 2 of how it is implemented is displayed
        System.out.println("Rule 2: Operand("+operand+") := "+
                Double.parseDouble(operand));
        //also boolean true is returned
        return true;
    }


    //this method is responsible for performing a required calculation between two operands
    //only the operator is passed through this method
    public void useOperator(String operator){
        //both operands are declared.
        //however operand 2 is of type Double so that it can have an initial value of null
        Double operand_2 = null;
        Double operand_1;

        //the below try exception block is checking if there are 2 operands and 1 operator to work with
        try {
            //the operator is popped out of the stack
            stack.pop();
            //then both operands are popped out
            operand_2 = Double.parseDouble(stack.pop());
            operand_1 = Double.parseDouble(stack.pop());

            //the switch statement checks which operator is used
            switch (operator) {
                case ("+"):
                    //if operator is + then the two operands are added together
                    //and the result is pushed onto the stack
                    //the result is truncated to 2dp
                    stack.push(decimalFormat.format(operand_1 + operand_2));
                    //this break statement is to prevent other cases from being executed
                    break;
                case ("-"):
                    //if operator is - then the operand 1 is taken away from operand 2
                    //and the result is pushed onto the stack
                    //the result is truncated to 2dp
                    stack.push(decimalFormat.format(operand_1 - operand_2));
                    break;
                case ("*"):
                    //if operator is * then the two operands are multiplied together
                    //and the result is pushed onto the stack
                    //the result is truncated to 2dp
                    stack.push(decimalFormat.format(operand_1 * operand_2));
                    break;
                case ("/"):
                    //if the operator is / then the divider is checked if it is a 0
                    if (operand_2 == 0) {
                        //if the divider is a 0 then the answer would be infinite which is a mathematical error
                        System.out.println("Error division by 0, the result will have a value of Infinity");
                        //and the program is stopped
                        System.exit(0);
                    }
                    //otherwise the result from the division is pushed onto the stack
                    //the result is truncated to 2dp
                    stack.push(decimalFormat.format(operand_1 / operand_2));
                    break;
            }
            //then Rule 3 and how it is implemented is displayed
            System.out.println("Rule 3: Operand(" +
                    stack.peek() +
                    ") := Operand(" +
                    operand_1 +
                    ") Operand(" +
                    operand_2 +
                    ") Operator(" +
                    operator +
                    ")");
        }

        //the only error to be produced should be an EmptyStackException
        //this means that either 1 or no operands where in the stack when being popped,
        //thus no mathematical operation could be performed on both operands if 1 or both are missing
        catch(EmptyStackException e){
            //if both operands are missing then the message displayed states the problem
            if (operand_2 == null){
                System.out.println("The stack above is missing both of the " +
                        "operands in order to perform the calculation process\n" +
                        "Please check the input and make changes to it.");
            }
            //otherwise only 1 operand is present and the message displayed states that
            else{
                System.out.println("The stack above is missing one operand " +
                        "in order to perform the calculation process\n" +
                        "Please check the input and make changes to it.");
            }
            //also the program is halted/finished
            System.exit(0);
        }

    }


    //this main method that is static is run automatically
    public static void main(String[] args) {
        //the user can edit and create their postfix notation expression below within the speech marks
        String post_fix_expression = "4.3 25 + 1.7 2 * - 3.2 /";
        //the interpreter object is created
        Interpreter interpreter = new Interpreter();
        //then its method calculate post fix expression is called and the user's
        //expression is passed through to be solved
        interpreter.calculate_post_fix_expression(post_fix_expression);
    }
}
