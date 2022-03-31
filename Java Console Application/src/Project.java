import java.util.*;
class Project {
    public static void main(String[] args) {
		logIn();
        String[] id = new String[20];
        String[] name = new String[id.length];
        int[] prf = new int[id.length];
        int[] dbms = new int[id.length];
        findInputs(id, name, prf, dbms);
    }

	// Print menu
    public static void getMenu() {
		
		//strBoldSize
        String B = "\033[0;1m";
        //strNormalSize
        String N = "\033[0;0m";
            
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("|%65s%23s\n","+"+B+"WELCOME TO GDSE MARKS MANAGEMENT SYSTEM"+N+"+","|");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("[1]  Add New Student\t\t\t  [2]  Add New Student With Marks");
        System.out.println("[3]  Add Marks\t\t\t\t  [4]  Update Student Details");
        System.out.println("[5]  Update Marks\t\t\t  [6]  Delete Student");
        System.out.println("[7]  Print Student Details\t\t  [8]  Print Student Rank");
        System.out.println("[9]  Best in Programming Fundamentals\t  [10] Best in Database Management System");
        System.out.println();
    }

    // Get Switch Cases
    public static void findInputs(String[] id, String[] name, int[] prf, int[] dbms) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an option to continue > ");
        int number = input.nextInt();
        clearConsole();
        switch (number) {
            case 1:
                addNewStudent(id, name, prf, dbms);
                break;
            case 2:
                addNewStudentWithMarks(id, name, prf, dbms);
                break;
            case 3:
                addMarks(id, name, prf, dbms);
                break;
            case 4:
                updateStudentDetails(id, name, prf, dbms);
                break;
            case 5:
                updateMarks(id, name, prf, dbms);
                break;
            case 6:
                deleteStudent(id, name, prf, dbms);
                break;
            case 7:
                printStudentDetails(id, name, prf, dbms);
                break;
            case 8:
                printStudentRank(id, name, prf, dbms);
                break;
            case 9:
                bestInProgrammingFundamentals(id, name, prf, dbms);
                break;
            case 10:
                bestInDatabaseManagementSystem(id, name, prf, dbms);
                break;
            default:
                System.out.println("Invalid Number...Try Again!");

        }

    }

    // Switch case 1 
    public static void addNewStudent(String[] id, String[] name, int[] prf, int[] dbms) {
        Scanner input = new Scanner(System.in);
        
            //strBoldSize
            String B = "\033[0;1m";
            //strNormalSize
            String N = "\033[0;0m";
        
            System.out.println("-----------------------------------------------------------------------------------------"+ "\n|\t\t\t\t"+B+"ADD NEW STUDENT"+N+"\t\t\t\t|\n"+ "-----------------------------------------------------------------------------------------");
            int index = nextValues(id);
       
     L1 :   for (int i = index; i < id.length; i++) {
            //carry=i;
            System.out.print("\nEnter Student ID : ");
            String tempory = input.next();

            // check if ID exists?
            boolean studentIdFound = false;
            for (int j = 0; j < id.length; j++) {
                if (tempory.equals(id[j])) {
                    System.out.println("The Student ID already exists");
                    studentIdFound = true;
                    break;
                }
            }
            // either the studentId was found, or not found so...

            if (!studentIdFound) {
                id[i] = tempory;

                System.out.print("Enter Student Name : ");
                name[i] = input.next();

                //System.out.println(Arrays.toString(id));
                //System.out.println(Arrays.toString(name));
                //System.out.println(Arrays.toString(prf));
                //System.out.println(Arrays.toString(dbms));
                //System.out.println();

                System.out.print("Student has been addes sucessfully. Do you want to add a new Student (Y/n) : ");
                char ch=input.next().charAt(0);
		        switch(ch){
			    case 'y' :
			    case 'Y' :clearConsole();System.out.println("-----------------------------------------------------------------------------------------"+ "\n|\t\t\t\t"+B+"ADD NEW STUDENT"+N+"\t\t\t\t|\n"+ "-----------------------------------------------------------------------------------------");break; 				
			    default :System.out.println("Sorry for removing you from the software due to an incorrect entry...!"); System.exit(0);
			    case 'n' :
			    case 'N' :clearConsole();getMenu();findInputs(id,name,prf,dbms);break;
			    } 
            }

            if (studentIdFound) {
                i--; // retry
            }
        }
    }

    // The Add New Student method finds the Null location after entering the initial
    // values in the Store Array.
    public static int nextValues(String[] id) {
        int newArray = id.length;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == null) {
                newArray = i;
                break;

            }

        }

        return newArray;
    }

    // Switch case 2 
    public static void addNewStudentWithMarks(String[] id, String[] name, int[] prf, int[] dbms) {
        Scanner input = new Scanner(System.in);
        
        //strBoldSize
        String B = "\033[0;1m";
        //strNormalSize
        String N = "\033[0;0m";
        
        System.out.println("-----------------------------------------------------------------------------------------"+ "\n|\t\t\t"+B+"ADD NEW STUDENT WITH MARKS"+N+"\t\t\t|\n"+ "-----------------------------------------------------------------------------------------");
        //System.out.println(Arrays.toString(id));

        boolean b = true;
        while (b == true) {
            //method call search null values
            int index = nextValues(id);
            for (int i = index; i < id.length; i++) {

                System.out.print("\nEnter Student ID   : ");
                String temp = input.next();

                // check if ID exists?
                boolean existsIdFound = false;
                for (int j = 0; j < id.length; j++) {
                    if (temp.equals(id[j])) {
                        System.out.println("The Student ID already exists");
                        existsIdFound = true;
                        break;
                    }
                }

                if (!existsIdFound) {
                    id[i] = temp;

                    System.out.print("Enter Student Name : ");
                    name[i] = input.next();
                    System.out.println();

                    do {
                        System.out.print("Programming Fundemantal Marks    : ");
                        prf[i] = input.nextInt();
                        if (prf[i] < 0 || prf[i] > 100) {
                            System.out.println("Invalid marks, please enter correct marks.");
                        }
                    } while (prf[i] < 0 || prf[i] > 100);

                    do {
                        System.out.print("Database Management System Marks : ");
                        dbms[i] = input.nextInt();
                        if (dbms[i] < 0 || dbms[i] > 100) {
                            System.out.println("Invalid marks, please enter correct marks.");
                        }
                    } while (dbms[i] < 0 || dbms[i] > 100);

                    //System.out.println(Arrays.toString(id));
                    //System.out.println(Arrays.toString(name));
                    //System.out.println(Arrays.toString(prf));
                    //System.out.println(Arrays.toString(dbms));
                    
                    System.out.println();
                    System.out.print("Student has been added successfully.Do you want to add a new student(Y/n) : ");
                    char ch=input.next().charAt(0);
		            switch(ch){
			          case 'y' :
			          case 'Y' :clearConsole();System.out.println("-----------------------------------------------------------------------------------------"+ "\n|\t\t\t\t"+B+"ADD NEW STUDENT WITH MARKS"+N+"\t\t\t\t|\n"+ "-----------------------------------------------------------------------------------------");break; 				
			          default :System.out.println("Sorry for removing you from the software due to an incorrect entry...!"); System.exit(0);
			          case 'n' :
			          case 'N' :clearConsole();getMenu();findInputs(id,name,prf,dbms);break;
			        }
			    } 
                if (existsIdFound) {
                    i--;
               }
            }
        }
    }

    // Switch case 3 
    public static void addMarks(String[] id, String[] name, int[] prf, int[] dbms) {
        Scanner input = new Scanner(System.in);
        
        //strBoldSize
        String B = "\033[0;1m";
        //strNormalSize
        String N = "\033[0;0m";
        
        System.out.println("-----------------------------------------------------------------------------------------"+ "\n|\t\t\t\t\t"+B+"ADD MARKS"+N+"\t\t\t\t\t|\n"+ "-----------------------------------------------------------------------------------------");
        System.out.println();

        char y;
        L1: for (int i = 0; i < id.length; i++) {

            System.out.print("Enter Student ID  : ");
            String temp = input.next();

            L2: for (int j = 0; j < id.length; j++) {

                if (temp.equals(id[j])) {
                    System.out.println("Student Name : " + name[j]);

                    if (prf[j] == 0) {
                        do {
                            System.out.print("\nProgramming Fundemantals Marks : ");
                            prf[j] = input.nextInt();
                            if (prf[j] < 0 || prf[j] > 100) {
                                System.out.println("Invalid marks, please enter correct marks");
                                System.out.println();
                            }
                        } while (prf[j] < 0 || prf[j] > 100);

                        do {
                            System.out.print("Database Management System Marks : ");
                            dbms[j] = input.nextInt();
                            if (dbms[j] < 0 || dbms[j] > 100) {
                                System.out.println("Invalid marks, please enter correct marks");
                            }
                        } while (dbms[j] < 0 || dbms[j] > 100);

                        //System.out.println(Arrays.toString(id));
                        //System.out.println(Arrays.toString(name));
                        //System.out.println(Arrays.toString(prf));
                        //System.out.println(Arrays.toString(dbms));
                        //System.out.println();

                        System.out.print("Marks have been added. Do you want to add marks for another student? (Y/n) : ");
                        char ch=input.next().charAt(0);
		                switch(ch){
			              case 'y' :
			              case 'Y' :clearConsole();System.out.println("-----------------------------------------------------------------------------------------"+ "\n|\t\t\t\t\t"+B+"ADD MARKS"+N+"\t\t\t\t\t|\n"+ "-----------------------------------------------------------------------------------------");break; 				
			              default :System.out.println("Sorry for removing you from the software due to an incorrect entry...!"); System.exit(0);
			              case 'n' :
			              case 'N' :clearConsole();getMenu();findInputs(id,name,prf,dbms);break;
			           }
                        continue L1;

                    } else if (prf[j] != 0) {

                        System.out.println("This student's marks have been already added.\nIf you want to update marks, please use [4] Update Marks option.");
                        System.out.print("\nDo you want to add marks for anthor student? (Y/n) : ");
                        y = input.next().charAt(0);
                        switch(y){
			              case 'y' :
			              case 'Y' :clearConsole();System.out.println("-----------------------------------------------------------------------------------------"+ "\n|\t\t\t\t\tADD MARKS\t\t\t\t\t|\n"+ "-----------------------------------------------------------------------------------------");break; 				
			              default :System.out.println("Sorry for removing you from the software due to an incorrect entry...!"); System.exit(0);
			              case 'n' :
			              case 'N' :clearConsole();getMenu();findInputs(id,name,prf,dbms);break;
			           }
                        i--;
                        continue L1;
                    }
                }
            }

            L3: if (!temp.equals(id[i])) {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n) : ");
                y = input.next().charAt(0);
                switch(y){
			      case 'y' :
			      case 'Y' :break; 				
			      default :System.out.println("Sorry for removing you from the software due to an incorrect entry...!"); System.exit(0);
			      case 'n' :
			      case 'N' :clearConsole();getMenu();findInputs(id,name,prf,dbms);break;
			   }
               break L3;
            }
        }
    }

    // Switch case 4 
    public static void updateStudentDetails(String[] id, String[] name, int[] prf, int[] dbms) {
        Scanner input = new Scanner(System.in);
        
        //strBoldSize
        String B = "\033[0;1m";
        //strNormalSize
        String N = "\033[0;0m";
        
        System.out.println("-----------------------------------------------------------------------------------------"+ "\n|\t\t\t\t"+B+"UPDATE STUDENT DETAILS"+N+"\t\t\t\t\t|\n"+ "-----------------------------------------------------------------------------------------");
        System.out.println();

        L1: for (int i = 0; i < id.length; i++) {
            System.out.print("Enter Student ID : ");
            String tempId = input.next();

            char y;
            L2: for (int j = 0; j < id.length; j++) {

                if (tempId.equals(id[j])) {
                    System.out.println("Student Name : " + name[j]);

                    System.out.print("\nEnter the new Student Name : ");
                    String tempName = input.next();
                    name[j] = tempName;

                    //System.out.println(Arrays.toString(id));
                    //System.out.println(Arrays.toString(name));
                    //System.out.println(Arrays.toString(prf));
                    //System.out.println(Arrays.toString(dbms));
                    //System.out.println();

                    System.out.print("Student details has been updated succesfully.\nDo you want to update another student details? (Y/n) : ");
                    y = input.next().charAt(0);
                     switch(y){
			           case 'y' :
			           case 'Y' :clearConsole();System.out.println("-----------------------------------------------------------------------------------------"+ "\n|\t\t\t\t"+B+"UPDATE STUDENT DETAILS"+N+"\t\t\t\t\t|\n"+ "-----------------------------------------------------------------------------------------");continue L1;				
			           default :System.out.println("Sorry for removing you from the software due to an incorrect entry...!"); System.exit(0);
			           case 'n' :
			           case 'N' :clearConsole();getMenu();findInputs(id,name,prf,dbms);break;
			        }
                }
            }

            L3: if (!tempId.equals(id[i])) {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n) : ");
                y = input.next().charAt(0);
                switch(y){
                  case 'y' :
			      case 'Y' :break; 				
			      default :System.out.println("Sorry for removing you from the software due to an incorrect entry...!"); System.exit(0);
			      case 'n' :
			      case 'N' :clearConsole();getMenu();findInputs(id,name,prf,dbms);break;
			   }
               break L3;
            }
        }
    }

    // Switch case 5
    public static void updateMarks(String[] id, String[] name, int[] prf, int[] dbms) {
        Scanner input = new Scanner(System.in);
        
        //strBoldSize
        String B = "\033[0;1m";
        //strNormalSize
        String N = "\033[0;0m";
        
        System.out.println("-----------------------------------------------------------------------------------------"+ "\n|\t\t\t\t\t"+B+"UPDATE MARKS"+N+"\t\t\t\t\t|\n"+ "-----------------------------------------------------------------------------------------");
        System.out.println();

        char y;
        L1: for (int i = 0; i < id.length; i++) {

            System.out.print("Enter Student ID : ");
            String tempId = input.next();

            L2: for (int j = 0; j < id.length; j++) {
                if (tempId.equals(id[j])) {
                    System.out.println("Student Name : " + name[j]);

                    if (prf[j] != 0) {
                        System.out.println("\nProgramming Fundamental Marks  : " + prf[j]);
                        System.out.println("Database Management System Marks : " + dbms[j]);
                        do {
                            System.out.print("\nEnter New Programming Fundamental Marks : ");
                            prf[j] = input.nextInt();
                            if (prf[j] < 0 || prf[j] > 100) {
                                System.out.println("Invalid marks, please enter correct marks");
                            }
                        } while (prf[j] < 0 || prf[j] > 100);

                        do {
                            System.out.print("Enter New Database Management System Marks : ");
                            dbms[j] = input.nextInt();
                            if (dbms[j] < 0 || dbms[j] > 100) {
                                System.out.println("Invalid marks, please enter correct marks");
                            }
                        } while (dbms[j] < 0 || dbms[j] > 100);

                        //System.out.println(Arrays.toString(id));
                        //System.out.println(Arrays.toString(name));
                        //System.out.println(Arrays.toString(prf));
                        //System.out.println(Arrays.toString(dbms));
                        //System.out.println();

                        System.out.print("Marks have been updated succesfully.\nDo you want to update marks for another student? (Y/n) : ");
                        y = input.next().charAt(0);
                         switch(y){
                           case 'y' :
			               case 'Y' :clearConsole();System.out.println("-----------------------------------------------------------------------------------------"+ "\n|\t\t\t\t\t"+B+"UPDATE MARKS"+N+"\t\t\t\t\t|\n"+ "-----------------------------------------------------------------------------------------");break; 				
			               default :System.out.println("Sorry for removing you from the software due to an incorrect entry...!"); System.exit(0);
			               case 'n' :
			               case 'N' :clearConsole();getMenu();findInputs(id,name,prf,dbms);break L1;   
                        }
                        continue L1;
                    }
                    if (prf[j] == 0) {
                        System.out.print("\nThis student's marks yet to be added.\nDo you want to update the marks of another student? (Y/n) : ");
                         y = input.next().charAt(0);
                         switch(y){
                           case 'y' :
			               case 'Y' :break; 				
			               default :System.out.println("Sorry for removing you from the software due to an incorrect entry...!"); System.exit(0);
			               case 'n' :
			               case 'N' :clearConsole();getMenu();findInputs(id,name,prf,dbms);break;
			             }
                        i--;
                        continue L1;
                    }
                }
            }
            L3: if (!tempId.equals(id[i])) {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n) : ");
                y = input.next().charAt(0);
                switch(y){
                  case 'y' :
			      case 'Y' :break; 				
			      default :System.out.println("Sorry for removing you from the software due to an incorrect entry...!"); System.exit(0);
			      case 'n' :
			      case 'N' :clearConsole();getMenu();findInputs(id,name,prf,dbms);break;
			    }
                i--;
                break L3;
            }
        }
    }

    // Switch case 6 
    public static void deleteStudent(String[] id, String[] name, int[] prf, int[] dbms) {
        Scanner input = new Scanner(System.in);
        
        //strBoldSize
        String B = "\033[0;1m";
        //strNormalSize
        String N = "\033[0;0m";
        
        System.out.println("-----------------------------------------------------------------------------------------"+ "\n|\t\t\t\t\t"+B+"DELETE STUDENT"+N+"\t\t\t\t\t|\n"+ "-----------------------------------------------------------------------------------------");
        System.out.println();

        //System.out.println(Arrays.toString(id));
        //System.out.println(Arrays.toString(name));
        //System.out.println(Arrays.toString(prf));
        //System.out.println(Arrays.toString(dbms));
        //System.out.println();

        L1: for (int i = 0; i < id.length; i++) {

            System.out.print("Enter Student ID : ");
            String temp = input.next();

            L2: for (int j = 0; j < id.length; j++) {

                if (temp.equals(id[j])) {
                    for (int x = j; x < id.length - 1; x++) {
                        id[x] = id[x + 1];
                        name[x] = name[x + 1];
                        prf[x] = prf[x + 1];
                        dbms[x] = dbms[x + 1];
                    }
                    String tempId[] = new String[id.length - 1];
                    String tempName[] = new String[id.length - 1];
                    int tempPrf[] = new int[id.length - 1];
                    int tempDbms[] = new int[id.length - 1];
                    
                    for (int l = 0; l < tempId.length; l++) {
                        tempId[l] = id[l];
                        tempName[l] = name[l];
                        tempPrf[l] = prf[l];
                        tempDbms[l] = dbms[l];
                    }
                    id = tempId;
                    name = tempName;
                    prf = tempPrf;
                    dbms = tempDbms;

                    //System.out.println(Arrays.toString(id));
                    //System.out.println(Arrays.toString(name));
                    //System.out.println(Arrays.toString(prf));
                    //System.out.println(Arrays.toString(dbms));
                    //System.out.println();

                    System.out.print("Student has been deleted  sucesfully\nDo you want to delete another student? (Y/n) : ");
                    char ch = input.next().charAt(0);
                    switch(ch){
			         case 'y' :
			         case 'Y' :clearConsole();System.out.println("-----------------------------------------------------------------------------------------"+ "\n|\t\t\t\t\t"+B+"DELETE STUDENT"+N+"\t\t\t\t\t|\n"+ "-----------------------------------------------------------------------------------------");break; 				
			         default :System.out.println("Sorry for removing you from the software due to an incorrect entry...!"); System.exit(0);
			         case 'n' :
			         case 'N' :clearConsole();getMenu();findInputs(id,name,prf,dbms);break;
			       }
                    continue L1;
                }
                // System.out.println("id "+Arrays.toString(id));
                // System.out.println("ar "+Arrays.toString(ar));
            }

            L3: if (!temp.equals(id[i])) {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n) : ");
                char y = input.next().charAt(0);
                switch(y){
			      case 'y' :
			      case 'Y' :break; 				
			      default :System.out.println("Sorry for removing you from the software due to an incorrect entry...!"); System.exit(0);
			      case 'n' :
			      case 'N' :clearConsole();getMenu();findInputs(id,name,prf,dbms);break;
			   }
                i--;
                break L3;
            }
        }
    }

    // Switch case 7
    public static void printStudentDetails(String[] id, String[] name, int[] prf, int[] dbms) {
        Scanner input = new Scanner(System.in);
       
        //strBoldSize
        String B = "\033[0;1m";
        //strNormalSize
        String N = "\033[0;0m";
        
        System.out.println("-----------------------------------------------------------------------------------------"+ "\n|\t\t\t\t"+B+"PRINT STUDENT DETAILS"+N+"\t\t\t\t\t|\n"+ "-----------------------------------------------------------------------------------------");
        System.out.println();
        int index = nextValues(id);
   
        int[] temp=studentsort(prf,dbms);
        int[] sTot=new int[id.length];
        double [] sAvg=new double[id.length];
        //int[] rank=new int[id.length];

        for(int i=0;i<id.length;i++){
			sTot[i]=prf[i]+dbms[i];
			sAvg[i]=(double)(sTot[i]/2);
		}
        
         //System.out.println(Arrays.toString(id));
         //System.out.println(Arrays.toString(name));
         //System.out.println(Arrays.toString(prf));
         //System.out.println(Arrays.toString(dbms));
         //System.out.println(Arrays.toString(sTot));
         //System.out.println(Arrays.toString(sAvg));
         
        L1 :for (int i = 0; i < id.length; i++){
			
            System.out.print("Enter Student Id : ");
            String tempId=input.next();

         L2 :for (int j = 0; j < id.length; j++){
                
                // Let's find the name of the student related to the id.
                if(tempId.equals(id[j])){
					System.out.println("Student Name : "+name[j]);
                     int tot=prf[j]+dbms[j];
                    
                     //System.out.println(tot);
                     //System.out.println(sAvg);
                    
                    // Search Marks yet to be added
                    if(tot==0){
                        System.out.print("Marks yet to be added\n");
                        System.out.print("Do you want to search another student details? (Y/n) ");
                        char ch=input.next().charAt(0);
                        switch(ch){
			              case 'y' :
			              case 'Y' :clearConsole();break;			
			              default :System.out.println("Sorry for removing you from the software due to an incorrect entry...!"); System.exit(0);
			              case 'n' :
			              case 'N' :clearConsole();getMenu();findInputs(id,name,prf,dbms);break;
			              
			           }
			           continue L1;
                    }

                    for (int k = 0; k < temp.length; k++){
                        if(tot==temp[k]){
                            int a=(temp.length)-(k);
                            
                            // Print Detils Table
                            System.out.println("+---------------------------------------+----------------+");
                            System.out.print  ("|Programming Fundamental Marks\t\t|");
                            System.out.printf("%16d",prf[j]);
                            System.out.print  ("|\n|Database Management Marks\t\t|");
                            System.out.printf("%16d",dbms[j]);
                            System.out.print  ("|\n|Total Marks\t\t\t\t|");
                            System.out.printf("%16d",sTot[j]);
                            System.out.print  ("|\n|Avg. Marks\t\t\t\t|");
                            System.out.printf("%16.2f",sAvg[j]);
                            System.out.print  ("|\n|Rank\t\t\t\t\t|");
                            System.out.print("\t\t"+a);
                            System.out.print("|");
                            System.out.println("\n+---------------------------------------+----------------+");
                          
                            //System.out.println(Arrays.toString(id));
                            //System.out.println(Arrays.toString(name));
                            //System.out.println(Arrays.toString(prf));
                            //System.out.println(Arrays.toString(dbms));
                            //System.out.println(Arrays.toString(sTot));
                            //System.out.println(Arrays.toString(sAvg));
                            
                            System.out.print("Do you want search another student details? (Y/n) : ");
                            char YorN=input.next().charAt(0);
		                    switch(YorN){
			                  case 'y' :
			                  case 'Y' :clearConsole();System.out.println("-----------------------------------------------------------------------------------------"+ "\n|\t\t\t\t"+B+"PRINT STUDENT DETAILS"+N+"\t\t\t\t\t|\n"+ "-----------------------------------------------------------------------------------------");continue L1;	
			                  default :System.out.println("Sorry for removing you from the software due to an incorrect entry...!"); System.exit(0);
			                  case 'n' :
			                  case 'N' :clearConsole();getMenu();findInputs(id,name,prf,dbms);
			               }
                        }
                    }
                }
            }
            
            // Search Invalid Student ID.
            if(!tempId.equals(id[i])){
                System.out.print("Invalid Student ID.\nDo you want to search again? (Y/n) : ");
                char ch=input.next().charAt(0);
                switch(ch){
			      case 'y' :
			      case 'Y' :continue L1;	
			      default :System.out.println("Sorry for removing you from the software due to an incorrect entry...!"); System.exit(0);
			      case 'n' :
			      case 'N' :clearConsole();getMenu();findInputs(id,name,prf,dbms);
			   }
            }		
        }
    }
 
    // Student Sort
    public static int[] studentsort(int[] fundemental,int[] database){
        int[] total=new int[fundemental.length];
        for (int i = 0; i < fundemental.length; i++)
        {
            total[i]=fundemental[i]+database[i];
        }
        int[] x=new int[total.length];
        x=total;
        for(int j=0; j<x.length-1; j++){
            for(int i=0; i<x.length-1; i++){
                if(x[i]>x[i+1]){
                    int t=x[i];
                    x[i]=x[i+1];
                    x[i+1]=t;
                }
            }
        }
        return x;
    }
    
    // Sort Array
    public static int[] sortArray(int[] total){

        for (int i = total.length; i >0; i--){
            int min=total[0];
            int index=0;
            for (int j =1; j < i; j++)
            {
                if(total[j]<min){
                    min=total[j];
                    index=j;

                }
            }
            total[index]=total[i-1];
            total[i-1]=min;
        }

        return total;

    }
    
    // Switch case 8
    public static void printStudentRank(String[] id, String[] name, int[] prf, int[] dbms) {
        Scanner input = new Scanner(System.in);
        
        //strBoldSize
        String B = "\033[0;1m";
        //strNormalSize
        String N = "\033[0;0m";
        
        System.out.println("-----------------------------------------------------------------"+"\n|\t\t\t "+B+"PRINT STUDENTS' RANK"+N+" \t\t\t|\n"+"-----------------------------------------------------------------");
        System.out.println();

        int[] temp=studentsort(prf,dbms);       
        int[] total=new int[id.length];
        double[] sAvg=new double[id.length];
        //int[] rank=sortArray(total);
        
        System.out.println("+------+--------+----------------------+------------+-----------+");
        System.out.println("|Rank  |ID      |Name                  |Total Marks |Avg. Marks |");
        System.out.println("+------+--------+----------------------+------------+-----------+");

        //Print Id
        for(int i=0;i<id.length;i++){
			total[i]=prf[i]+dbms[i];
			sAvg[i]=(double)(total[i]/2);
			
			}
			int index=nextValues(id);
			
		L1:	for(int i=0;i<id.length;i++){
			  for (int k = 0; k < temp.length; k++){
                 if(total[i]==temp[k]){
                    int a=(temp.length-1)-(k);
                      if(total[i]==0&&sAvg[i]==0){continue L1;}
				      System.out.printf("%s%-6d%s%-8s%s%-22s%s%12d%s%10.2f %s\n","|",a,"|",id[i],"|",name[i],"|",total[i],"|",sAvg[i],"|");
				      break;
			     }
		      }
	    }    
	
		System.out.println("+------+--------+----------------------+------------+-----------+");	
        System.out.println();
        System.out.print("Do you want to go back to main menu? (Y/n) : ");
		char ch=input.next().charAt(0);
		switch(ch){
			case 'y' :
			case 'Y' :clearConsole();getMenu();findInputs(id,name,prf,dbms);break; 				
			default :System.out.println("Sorry for removing you from the software due to an incorrect entry...!"); System.exit(0);
			case 'n' :
			case 'N' :System.exit(0);
			} 
        }  
	
    // Dbms Marks 
    public static int [] dbmsSort(int [] dbms){
        int []dbmsMark=new int[dbms.length];
        
        for (int i = 0; i < dbmsMark.length ; i++){
            dbmsMark[i]=dbms[i];
        }

        int [] temp=new int[dbmsMark.length];
        temp=dbmsMark;
        
        for(int j=0; j<temp.length-1; j++){
            for(int i=0; i<temp.length-1; i++){
                if(temp[i]>temp[i+1]){
                    int t=temp[i];
                    temp[i]=temp[i+1];
                    temp[i+1]=t;
                }
            }
        }
      return temp;
    }

    //Prf Marks Sort
    public static int [] pfSort(int [] prf){
        int []pfMark=new int[prf.length];
        for (int i = 0; i < pfMark.length ; i++){
            pfMark[i]=prf[i];
        }
        System.out.println(Arrays.toString(pfMark));
        int [] temp=new int[pfMark.length];
        temp=pfMark;
        for(int j=0; j<temp.length-1; j++){
            for(int i=0; i<temp.length-1; i++){
                if(temp[i]>temp[i+1]){
                    int t=temp[i];
                    temp[i]=temp[i+1];
                    temp[i+1]=t;
                }
            }
        }
        System.out.println(Arrays.toString(temp));
        return temp;
    }
    
    // Switch case 9 
    public static void bestInProgrammingFundamentals(String[] id, String[] name, int[] prf, int[] dbms) {
        Scanner input = new Scanner(System.in);
        
        //strBoldSize
        String B = "\033[0;1m";
        //strNormalSize
        String N = "\033[0;0m";
        
        System.out.println("--------------------------------------------------"+ "\n|\t "+B+"BEST IN PROGRAMMING FUNDAMENTALS"+N+" \t |\n"+ "--------------------------------------------------");
        
        int index=nextValues(id);
        int []temp=pfSort(prf);
        int []pfMark=new int[index];

        for (int i = 0; i < pfMark.length ; i++){
            pfMark[i]=prf[i];
        }
        
        System.out.println();
        System.out.println("+-----+--------------------+----------+----------+");
        System.out.println("|ID   |Name                |PF Marks  |DBMS Marks|");
        System.out.println("+-----+--------------------+----------+----------+");
        
          L1: for( int i=temp.length-1; i>=0 ; i--){
                for( int j=pfMark.length-1; j>=0; j--){
                    if(pfMark[j]==temp[i]){
                        if(temp[i]==0&&dbms[j]==0){break L1;}
                        System.out.printf("|%-5s|%-20s|%10d|%10d|\n",id[j],name[j],temp[i],dbms[j]);
                        break;
                    }
                }
            }
 
        System.out.println("+-----+--------------------+----------+----------+");
        System.out.println();
        System.out.print("Do you want to go back to main menu? (Y/n) : ");
		char ch=input.next().charAt(0);
		switch(ch){
			case 'y' :
			case 'Y' :clearConsole();getMenu();findInputs(id,name,prf,dbms);break; 				
			default :System.out.println("Sorry for removing you from the software due to an incorrect entry...!"); System.exit(0);
			case 'n' :
			case 'N' :System.exit(0);
			}	
    }

    // Switch case 10 
    public static void bestInDatabaseManagementSystem(String[] id, String[] name, int[] prf, int[] dbms) {
        Scanner input = new Scanner(System.in);
        
        //strBoldSize
        String B = "\033[0;1m";
        //strNormalSize
        String N = "\033[0;0m";
        
        System.out.println("--------------------------------------------------"+ "\n|\t"+B+"BEST IN DATABASE MANAGEMENT SYSTEM"+N+"  \t |\n"+ "--------------------------------------------------");
        
        int index=nextValues(id);
        int []temp=dbmsSort(dbms);
        int[] pfMark=new int[index];
        String copyId[]=new String[20];
        String copyName[]=new String[20];
        
        for (int i = 0; i < pfMark.length ; i++){
            pfMark[i]=dbms[i];
            copyId[i]=id[i];
			copyName[i]=name[i];			
			
		}
		
		//System.out.println(Arrays.toString(copyId));
        //System.out.println(Arrays.toString(copyName));
        //System.out.println(Arrays.toString(prf));
        //System.out.println(Arrays.toString(temp));
        //System.out.println();
        System.out.println();
        
        System.out.println("+-----+--------------------+----------+----------+");
        System.out.println("|ID   |Name                |DBMS Marks|PF Marks  |");
        System.out.println("+-----+--------------------+----------+----------+");

			 L1: for( int i=temp.length-1; i>=0 ; i--){
                for( int j=pfMark.length-1; j>=0; j--){
					
                    if(pfMark[j]==temp[i]){
                        if(temp[i]==0&&prf[j]==0){break L1;}
                        System.out.printf("|%-5s|%-20s|%10d|%10d|\n",copyId[j],copyName[j],temp[i],prf[j]);
                        break; 
                    }
                }
            }
	
        System.out.println("+-----+--------------------+----------+----------+");
        System.out.println();
        
        System.out.print("Do you want to go back to main menu? (Y/n) : ");
		char ch=input.next().charAt(0);
		switch(ch){
			case 'y' :
			case 'Y' :clearConsole();getMenu();findInputs(id,name,prf,dbms);break; 				
			default :System.out.println("Sorry for removing you from the software due to an incorrect entry...!"); System.exit(0);
			case 'n' :
			case 'N' : System.exit(0);
			} 
    }

    // Logging
    public static void logIn(){
	  Scanner input=new Scanner(System.in);
	  //strBoldSize
        String B = "\033[0;1m";
        //strNormalSize
        String N = "\033[0;0m";
        
        String user;
        String password;    
            
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("|%65s%23s\n","+"+B+"WELCOME TO GDSE MARKS MANAGEMENT SYSTEM"+N+"+","|");
        System.out.printf("|%50s%38s\n","+"+B+"Logging Page"+N+"+","|");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();    
      
        System.out.print("\t\tEnter User Name : ");
        user=input.next();
        System.out.print("\t\tEnter Password  : ");
        password=input.next();
      
       if(password.equals("1234") && user.equals("pahasara")){
			clearConsole();
			getMenu();
		}else{
			while(true){
			System.out.println("\t\tInvalid User name or Password,try again...!");
			System.out.print("\t\tEnter User Name : ");
            user=input.next();
            System.out.print("\t\tEnter Password  : ");
            password=input.next();
	   		 if(password.equals("1234") && user.equals("pahasara")){
		    	clearConsole();
			    getMenu();
			    break;
			}
		}
	}	
}
	 
    // Clear Console
    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }
}
