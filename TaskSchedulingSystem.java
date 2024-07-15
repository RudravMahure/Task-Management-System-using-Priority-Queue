import java.util.*;

public class TaskSchedulingSystem{
    Scanner sc = new Scanner(System.in);

    // Color to the text which is display on the screen
    public class ConsoleColors{
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

    // High Intensity
    public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    public static final String RED_BRIGHT = "\033[0;91m";    // RED
    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
    }

    // Node structure class
    public class Node{
        public int priority;
        public String task;
        public Node next;
    }

    //TaskSchedulingSystem obj = new TaskSchedulingSystem();
    public Node head;
    public Node temp;
    //public Node node;
    public Node prev;
    public Node compTemp;
    public Node compHead;
    public Node compNode;

    //public Node innerTemp;
    int count; //Size of SLL



    public void createTaskManagement(String value , int priority){
        Node node = new Node();
        if(head==null){
        head = new Node();
        node.priority = priority;
        node.task = value;
        node.next = null;
        head = node;
        temp = head;
        count++;
        }else{
            //node = new Node();
            node.priority = priority;
            node.task = value;
            temp.next = node;
            temp = node;   
            count++;     
        }

    }

    public void showLinkedList(){
        temp = head;
        while(temp!=null){
            System.out.println(temp.priority);
            temp  = temp.next;
        }
    }


    //Showing all the task
    public void showTask() {
        //System.out.println("INSIDE SHOW TASK");
        for (int tempPriority = 1; tempPriority <= 5; tempPriority++) {
            temp = head;
            while (temp != null) {
                if (temp.priority == tempPriority) {
                    System.out.println(temp.task + "\t\t" + temp.priority);
                }
                temp = temp.next;
            }
        }
    }

    // Show complete the task
    public void showCompleteTask(){
        if(compHead==null){
            System.out.println(ConsoleColors.RED+"YOUR HAVE NOT COMPLETED ANY TASK");
        }else{
            compTemp = compHead;
            while(compTemp!=null){
                System.out.println(ConsoleColors.WHITE+compTemp.task+"\t\t"+compTemp.priority+ConsoleColors.RESET);
                compTemp = compTemp.next;
            }
        }
        
    }

    //Delete Task
    public void deleteTask(String tasks){
        boolean track = true;
        temp = head;
        if(head.task.equals(tasks)){
            head = head.next;
            track = false;
        }else{
        while(temp!=null){
            if(temp.task.equals(tasks)){
                prev.next = temp.next;
                track = false;
            }
            prev = temp;
            temp = temp.next;
        }
        if(track==true){
            System.out.println(ConsoleColors.RED+""+tasks+" IS NOT IN YOUR TASK LIST"+ConsoleColors.RESET);
        }else{
            System.out.println("TASK DELETED: "+tasks);
        }
    }
    
    }


    //Completed Task
    //public void taskComplete(String tasks){
    //    boolean track = true;
    //    temp = head;
    //    compHead = new Node();
    //    if(compHead==null){
    //        compHead = new Node();
    //        while(temp!=null){
    //            if(temp.task.equals(tasks)){
    //                compHead.task=temp.task;
    //                compHead.priority=temp.priority;
    //                track=false;
    //            }
    //            temp=temp.next;
    //        }
    //        compTemp=compHead;
    //    }
    //    else{
    //        while(temp!=null){
    //            if(temp.task.equals(tasks)){
    //                compNode.task=temp.task;
    //                compNode.priority=temp.priority;
    //                track=false;
    //            }
    //            temp=temp.next;
    //        }
    //        compTemp.next=compNode;
    //    }
    //    if(track==false){
    //        System.out.println(ConsoleColors.RED+""+tasks+" IS NOT IN YOUR TASK LIST"+ConsoleColors.RESET);
    //    }
    //}

    public void taskComplete(String tasks) {
        boolean track = true;
        temp = head;
        
        while (temp != null) {
            if (temp.task.equals(tasks)) {
                Node compNode = new Node();
                compNode.task = temp.task;
                compNode.priority = temp.priority;
                compNode.next = null;
                
                if (compHead == null) {
                    compHead = compNode;
                    compTemp = compHead;
                } else {
                    compTemp.next = compNode;
                    compTemp = compNode;
                }
                
                track = false;
                break;
            }
            temp = temp.next;
        }

        if (track) {
            System.out.println(ConsoleColors.RED + tasks + " IS NOT IN YOUR TASK LIST" + ConsoleColors.RESET);
        }
    }



    // Menu code of the program
    public void menuDriven(){
        //TaskSchedulingSystem obj = new TaskSchedulingSystem();

        // Declare variables
        boolean exit_menu = true,create_exit=true;
        int choice = 0,priority;
        String task;

        do{

            // Display all the functions available
            System.out.println();
            System.out.println(ConsoleColors.CYAN+" 1.CREATE YOUR TODAY'S SCHEDULE \n 2.ADD MORE TASK \n 3.DELETE A TASK \n 4.MARKS AS COMPLETE \n 5.SHOW ALL MY TASK");
            System.out.println(ConsoleColors.YELLOW+"ENTER YOUR CHOICE"+ConsoleColors.RESET);
            choice = sc.nextInt();
            sc.nextLine();



            switch(choice){
                case 1:
                System.out.println();
                System.out.println(ConsoleColors.GREEN+"ADD YOUR TASK"+ConsoleColors.RESET);
                do{
                    // Adding task in Task Manager 
                    if(count == 0){
                    System.out.println();
                    System.out.println(ConsoleColors.CYAN+"ENTER YOUR TASK : "+ConsoleColors.RESET); // task input
                    task = sc.nextLine();
                    task = task.toUpperCase();
                    System.out.println(ConsoleColors.CYAN+"ENTER TASK PRIORITY (0 TO 5): "+ConsoleColors.RESET); //priority input
                    priority = sc.nextInt();
                    sc.nextLine();
                    createTaskManagement(task, priority);
                    System.out.println();
                    System.out.println(ConsoleColors.GREEN+"TASK ADDED IN SYSTEM"+ConsoleColors.RESET);
                }else{
                    System.out.println();
                    System.out.println(ConsoleColors.CYAN+"ENTER YOUR TASK : "+ConsoleColors.RESET); // task input
                    task = sc.nextLine();
                    task = task.toUpperCase();
                    System.out.println(ConsoleColors.CYAN+"ENTER TASK PRIORITY (0 TO 5): "+ConsoleColors.RESET); //priority input
                    priority = sc.nextInt();
                    sc.nextLine();
                    createTaskManagement(task, priority);
                    System.out.println();
                    System.out.println(ConsoleColors.GREEN+"TASK ADDED IN SYSTEM"+ConsoleColors.RESET);
                }
                    // Exiting loop or not
                    System.out.println();
                    System.out.println(ConsoleColors.WHITE+"DO YOU WANT TO ADD MORE TASK \n 1 FOR YES \n 0 FOR NO");
                    int create_num = sc.nextInt();
                    sc.nextLine();
                    if(create_num==1){
                        create_exit=true;
                    }else{
                        create_exit = false;
                    }
                }while(create_exit);
                   break;
                   

                //Adding task in Task Management System   
                case 2:

                // Adding task in Task Management System 
                if(count == 0){
                    System.out.println();
                    System.out.println(ConsoleColors.CYAN+"ENTER YOUR TASK : "+ConsoleColors.RESET); // task input
                    task = sc.nextLine();
                    task = task.toUpperCase();
                    System.out.println(ConsoleColors.CYAN+"ENTER TASK PRIORITY (0 TO 5) : "+ConsoleColors.RESET); //priority input
                    priority = sc.nextInt();
                    sc.nextLine();
                    createTaskManagement(task, priority);
                    System.out.println();
                    System.out.println(ConsoleColors.GREEN+"TASK ADDED IN SYSTEM"+ConsoleColors.RESET);
                }else{
                    System.out.println();
                    System.out.println(ConsoleColors.CYAN+"ENTER YOUR TASK : "+ConsoleColors.RESET); // task input
                    task = sc.nextLine();
                    task = task.toUpperCase();
                    System.out.println(ConsoleColors.CYAN+"ENTER TASK PRIORITY (0 TO 5): "+ConsoleColors.RESET); //priority input
                    priority = sc.nextInt();
                    sc.nextLine();
                    createTaskManagement(task, priority);
                    System.out.println();
                    System.out.println(ConsoleColors.GREEN+"TASK ADDED IN SYSTEM"+ConsoleColors.RESET);
                }
                   break;


                // Deleting the task   
                case 3:
                System.out.println();
                showTask();
                System.out.println();
                System.out.println(ConsoleColors.YELLOW+"ENTER THE TASK YOU WANT TO DELETE :"+ConsoleColors.RESET);
                String tasks=sc.nextLine();
                tasks = tasks.toUpperCase();
                deleteTask(tasks);
                   break;


                //  Complete the task 
                case 4:
                System.out.println();
                System.out.println(ConsoleColors.YELLOW+"ENTER THE TASK YOU HAVE COMPLETED : "+ConsoleColors.RESET);
                String compTask = sc.nextLine();
                compTask = compTask.toUpperCase();
                taskComplete(compTask);
                deleteTask(compTask);
                   break;

                // Showing Completed and InCompleted Task   
                case 5:
                System.out.println();
                System.out.println(ConsoleColors.CYAN+"TODAY'S TASK"+ConsoleColors.RESET);
                System.out.println();
                System.out.println(ConsoleColors.RED+"INCOMPLETE TASK"+ConsoleColors.RESET);
                System.out.println(ConsoleColors.WHITE+"TASK \t\t PRIORITY"+ConsoleColors.RESET);
                System.out.println();
                showTask();
                System.out.println();
                System.out.println(ConsoleColors.GREEN+"COMPLETE TASK"+ConsoleColors.RESET);
                System.out.println(ConsoleColors.WHITE+"TASK \t\t PRIORITY"+ConsoleColors.RESET);
                System.out.println();
                showCompleteTask();
                
                  break;   
                default :
                   //System.out.println();
                   //System.out.println(ConsoleColors.RED+"ENTER A PROPER VALUE"+ConsoleColors.RESET);
                   exit_menu = false;   
            }



            // Exit Statements of the menu driven program
            //System.out.println();
            //System.out.println(ConsoleColors.WHITE+"DO YOU WANT TO EXIT THIS SYSTEM : \n 1.YES \n 0.NO ");
            //exit_num = sc.nextInt();
            //sc.nextLine();
            ////If use enter 1 then system will exit the menu or if user enter 0 then loop while again run
            //if(exit_num==0){
            //    exit_menu = true;
            //}else{
            //    exit_menu = false;
            //}
        }while(exit_menu);
    }



    // Main Function
    public static void main(String []args){

        // Scanner class is imported
        Scanner sc = new Scanner(System.in);

        // Object creation of the original class
        TaskSchedulingSystem obj = new TaskSchedulingSystem();

        System.out.println(ConsoleColors.GREEN+"WELCOME TO TASK MANAGEMENT SYSTEM !!!");
        obj.createTaskManagement("VIDEO GAMES", 5);
        obj.createTaskManagement("BOOK READING", 3);
        obj.createTaskManagement("WEB CODING", 1);
        obj.createTaskManagement("PYTHON COURSE", 2);
        obj.createTaskManagement("WASHROOM CLEAN", 4);
        //obj.showLinkedList();
        obj.menuDriven();
        //obj.deleteTask("WEB CODING");
        //obj.showLinkedList();

        System.out.println();
        System.out.println(ConsoleColors.GREEN+"THANK YOU FOR USING TASK MANAGEMENT SYSTEM !!!");
        System.out.println();
    }
}