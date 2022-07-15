//////////////////////////////////////////////////////////
/*
 ___                            _              _
|_ _|_ __ ___  _ __   ___  _ __| |_ __ _ _ __ | |_
 | || '_ ` _ \| '_ \ / _ \| '__| __/ _` | '_ \| __|
 | || | | | | | |_) | (_) | |  | || (_| | | | | |_
|___|_| |_| |_| .__/ \___/|_|   \__\__,_|_| |_|\__|
              |_|
 _   _       _   _
| \ | | ___ | |_(_) ___ ___
|  \| |/ _ \| __| |/ __/ _ \
| |\  | (_) | |_| | (_|  __/
|_| \_|\___/ \__|_|\___\___|

*/
////////////////////////////////////////////////////////////
/*This system is carefully developed to trap all the errors and the 
algorithms in the methods are carefully designed and structured 
for optimum performance of this program. The error trappings output 
that prints in the terminal will not be similar to the instructions 
of the course work(sometimes), but the functionality is the same. 
All the changes were done after asking the instructors….*/  
///////////////////////////////////////////////////////////
//You can add floating point numbers as inputs................
//please make sure to input atlest 4 charactors in the names.....
///////////////////////////////////////////////////////////////////////////////////////////////////
// Coded by Ishan lahiru Sampath, (ID no:-  200206803002) for the course work (IJSE "GDSE63" PRF)//
///////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
class courseWork{
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
	public static boolean charDetect(String mark){
		char[] l = new char[11];
		int p=0;
		for (int i = 48; i <58 ; i++){
			l[p]=(char)i;
			p++;
		}
		l[10]='.';
		char[] x = mark.toCharArray();
		int cnt=0;
		for (int i = 0; i < x.length; i++){
			for (int j = 0; j < l.length; j++){
				if (l[j]==x[i]){
					cnt++;
				}
			}
		}
		if (cnt==x.length){
			return true;
		}
		else{
			return false;
		}
	}
	public static boolean validateMarks(String mark){
		char[] x = mark.toCharArray();
		if (x.length==0){
			System.out.print("Null input. please enter correct marks. \n");
			return false;
		}else{
			boolean chardetect=charDetect(mark);
			if (chardetect){
				float num=Float.parseFloat(mark);
				if (num<=100&num>=0){
				}else{
					System.out.println("Out of the range, number should in the range of (0-100). please enter correct marks. \n");
					return false;
				}
			}else{
				System.out.println("Characters detected. please enter correct marks. \n");
				return false;
			}
		}
		return true;
	}
	public static boolean checkInp(String inp,int[] lim){
		char[] c= inp.toCharArray();
		int cn = 0;
		for (int i = 0; i < c.length; i++){
			cn+=c[i];
		}
		int nm =(int)cn-48;
		if (nm  <= lim[1]  && nm >= lim[0]){
			return true;
		}else{
			if (nm==49)
			{
				return true;
			}
			return false;
		}
	}
	public static boolean checkInpYN(String inp,int[] lim){
		char[] c= inp.toCharArray();
		if (c.length==0){
			return false;
		}else{
			int cn = (int)c[0];
			if (cn  <= lim[1]  && cn >= lim[0]){
				if (cn==78||cn==110||cn==89||cn==121){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}
	}
	public static int returnInp(String inp,int[] lim){
		char[] c= inp.toCharArray();
		int cn = 0;
		for (int i = 0; i < c.length; i++){
			cn+=c[i];
		}
		int nm =(int)cn-48;
		if (nm==49)
		{
			return 10;
		}
		return nm;
	}
	public static boolean validateInpStuId(String inp){
		if(inp!= null && !inp.isEmpty()){
			char[] c= inp.toCharArray();
			c[0]=Character.toUpperCase(c[0]);
			if (c.length == 4  && (int)c[0] == 83 && (int)c[1] >= 48 && (int)c[1] <= 57  && (int)c[2] >= 48 && (int)c[2] <= 57  && (int)c[3] >= 48 && (int)c[3] <= 57 ){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	public static String idStringFormat(String id){
		char[] c= id.toCharArray();
		if (c.length!=0){
			c[0]=Character.toUpperCase(c[0]);
			String fmtted=String.valueOf(c);
			return fmtted;
		}else{
			return "coo";
		}
	}
	public static boolean searchId(String id,String[][] ar,int index){
		boolean notExists =true;
		l: for (int i = 0; i < ar[index].length; i++){
			if (id.equals(ar[index][i])){
				notExists=false;
				break l;
			}
		}
		return notExists;
	}
	public static int idLocation(String id,String[][] ar,int index){
		int existsId =-1;
		l: for (int i = 0; i < ar[index].length; i++){
			if (id.equals(ar[index][i])){
				existsId = i;
				break l;
			}
		}
		return existsId;
	}
	public static String[][] incrementAr(String[][] ar){
		String[][] temp=new String[ar.length][ar[0].length+1];
		for (int i = 0; i < ar.length; i++){
			for (int j = 0; j < ar[i].length; j++){
				temp[i][j]=ar[i][j];
			}
		}
			return temp;
	}
	public static String[][] decrementAr(String[][] ar,int id){
		String[][] temp=new String[ar.length][ar[0].length-1];
		for (int i = 0; i < ar.length; i++){
			for (int j = 0; j < ar[i].length; j++){
				if (j>=id){
					if (j==id){
						continue;
					}else{
						temp[i][j-1]=ar[i][j];
					}
				}else{
					temp[i][j]=ar[i][j];
				}
			}
		}
		return temp;
	}
	public static String[][] addToArray(String[][] ar,int inId,String value){
		int o=ar[inId].length-1;
		ar[inId][o]=value;
		return ar;
	}
	public static String[][] addToArraywithid(String[][] ar,int inId,String value,int location){
		ar[inId][location]=value;
		return ar;
	}
	public static boolean validateNameNull(String name){
		char[] c= name.toCharArray();
		if (c.length==0){
			return false;
		}else{
			return true;
		}	
	}
	public static String formatYN(String inp){
		char[] c= inp.toCharArray();
		c[0]=Character.toUpperCase(c[0]);
		String fmtted=String.valueOf(c);
		return fmtted;
	}
	public static float totalINSTD(String[][] ar ,int idl){
		float total=0;
		for (int i = 2; i < 4 ; i++){
			total+=	Float.parseFloat(ar[i][idl]);
		}
	return total;
	}
	public static int totalINSTDint(String[][] ar ,int idl){
		int total=0;
		for (int i = 2; i < 4 ; i++){
			total+=	Integer.parseInt(ar[i][idl]);
		}
	return total;
	}
	public static float averageINSTD(String[][] ar ,int idl){
		float avg=0;
		float tot=totalINSTD(ar,idl);
		avg=tot/2;
	return avg;
	}
	public static int rankINSTD(String[][] ar ,int idl){
		float[] ar1 = new float[ar[0].length];
		int[] ar2 = new int[ar[0].length];
		for (int i = 0; i <ar[0].length; i++){
			ar1[i]=totalINSTD(ar,i);
		}
		for (int i = 0; i < ar1.length; i++) {
			int count = 0;
			for (int j = 0; j < ar1.length; j++) {
				if (ar1[j] > ar1[i]) {
					count++;
				}
			}
			ar2[i] = count + 1;
		}
		int rc = ar2[idl];
	return rc;
	}
		public static int[] rankINSTDesc(String[][] ar){
		float[] ar1 = new float[ar[0].length];
		int[] ar2 = new int[ar[0].length];
		int[] ar3 = new int[ar[0].length];
		for (int i = 0; i <ar[0].length; i++){
			ar1[i]=totalINSTD(ar,i);
			ar3[i]=i;
		}
		for (int i = 0; i < ar1.length; i++) {
			int count = 0;
			for (int j = 0; j < ar1.length; j++) {
				if (ar1[j] > ar1[i]) {
					count++;
				}
			}
			ar2[i] = count + 1;
		}
		for (int i = 1; i < ar2.length; i++){
			for (int j = 0; j < i; j++){
				if (ar2[i]<ar2[j]){
					int temp=ar2[i];
					int temp2=ar3[i];
					ar2[i]=ar2[j];
					ar3[i]=ar3[j];
					ar2[j]=temp;
					ar3[j]=temp2;
				}
			}
		}
		//System.out.println(Arrays.toString(ar2));
	return ar3;
	}
	public static int[] rankINSTDescId(String[][] ar, int id){
		float[] ar1 = new float[ar[0].length];
		int[] ar2 = new int[ar[0].length];
		int[] ar3 = new int[ar[0].length];
			if (id!=100){
				for (int i = 0; i < ar[0].length; i++){
					ar1[i]=Float.parseFloat(ar[id][i]);
					ar3[i]=i;
				}
			}else{
				for (int i = 0; i <ar[0].length; i++){
					ar1[i]=totalINSTD(ar,i);
					ar3[i]=i;
			}
		}
		for (int i = 0; i < ar1.length; i++) {
			int count = 0;
			for (int j = 0; j < ar1.length; j++) {
				if (ar1[j] > ar1[i]) {
					count++;
				}
			}
			ar2[i] = count + 1;
		}
		for (int i = 1; i < ar2.length; i++){
			for (int j = 0; j < i; j++){
				if (ar2[i]<ar2[j]){
					int temp=ar2[i];
					int temp2=ar3[i];
					ar2[i]=ar2[j];
					ar3[i]=ar3[j];
					ar2[j]=temp;
					ar3[j]=temp2;
				}
			}
		}
		//System.out.println(Arrays.toString(ar2));//not been commented in the original uploded file
	return ar3;
	}
	public static int[] rankINSTDescIdodr(String[][] ar, int id){
		float[] ar1 = new float[ar[0].length];
		int[] ar2 = new int[ar[0].length];
		int[] ar3 = new int[ar[0].length];
			if (id!=100){
				for (int i = 0; i < ar[0].length; i++){
					ar1[i]=Float.parseFloat(ar[id][i]);
					ar3[i]=i;
				}
			}else{
				for (int i = 0; i <ar[0].length; i++){
					ar1[i]=totalINSTD(ar,i);
					ar3[i]=i;
				}
			}
			for (int i = 0; i < ar1.length; i++) {
			int count = 0;
			for (int j = 0; j < ar1.length; j++) {
				if (ar1[j] > ar1[i]) {
					count++;
				}
			}
			ar2[i] = count + 1;
		}
		for (int i = 1; i < ar2.length; i++){
			for (int j = 0; j < i; j++){
				if (ar2[i]<ar2[j]){
					int temp=ar2[i];
					int temp2=ar3[i];
					ar2[i]=ar2[j];
					ar3[i]=ar3[j];
					ar2[j]=temp;
					ar3[j]=temp2;
				}
			}
		}
		//System.out.println(Arrays.toString(ar2));
	return ar2;
	}
	public static boolean desimalCheck(String[][] ar, int idl){
		int cnt=0;
		for (int i = 2; i <=3; i++){
			for (int j = 0; j < ar[0].length; j++){
				char[] x = (ar[i][j]).toCharArray();
				for (int k = 0; k < x.length; k++){
					if ((int)x[k]==46){
						cnt++;
					}
				}
				
			}
		}
		if (cnt==0){
			return false;
		}else{
			return true;
		}
	}
	public static String[][] home(String[][] ar){
		clearConsole();
		Scanner input=new Scanner(System.in);
		int[] limit = {1,11};
		for (int i = 0; i < 97; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.print("|\t\t\t\tWELCOME TO GDSE MARKS MANAGEMENT SYSTEM\t\t\t\t|");
		System.out.println();
		for (int i = 0; i < 97; i++){
			System.out.print("-");
		}
		System.out.print("\n\n[1] Add New Student\t\t\t\t[2] Add new Student With Marks");
		System.out.print("\n[3] Add Marks\t\t\t\t\t[4] Update Student Details");
		System.out.print("\n[5] Update Marks\t\t\t\t[6] Delete Student");
		System.out.print("\n[7] Print Student Details\t\t\t[8] Print Student Ranks");
		System.out.print("\n[9] Best in Programming Fundementals\t\t[10] Best in Database Management System");
		int Q = 1;
		System.out.println();
		//System.out.println(Arrays.toString(ar[0]));
		//System.out.println(Arrays.toString(ar[1]));
		//System.out.println(Arrays.toString(ar[2]));
		//System.out.println(Arrays.toString(ar[3]));
		while(Q==1){
			String navgter;
			System.out.print("\n\nEnter an option to continue > ");
			navgter=input.nextLine();
			boolean check = checkInp(navgter,limit);
			int nav = returnInp(navgter,limit);
			if (check){
				Q=0;
				switch (nav) {
					case 1:ar=addNewStudent(ar);break;
					case 2:ar=ansWithMarks(ar);break;
					case 3:ar=addMarks(ar);break;
					case 4:ar=updateStuDtl(ar);break;
					case 5:ar=updateMarks(ar);break;
					case 6:ar=deleteStudent(ar);break;
					case 7:printStuDetails(ar);break;
					case 8:printStudentRank(ar);break;
					case 9:BestInPrf(ar);break;
					case 10:bestInDbms(ar);break;
				}
			}else{
				System.out.println("Wrong Input,Try again.");
				Q=1;
			}
		}
		return ar;
	}
	public static String[][] addNewStudent(String[][] ar){
		clearConsole();
		Scanner input=new Scanner(System.in);
		for (int i = 0; i < 97; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.print("|\t\t\t\t\t   ADD NEW STUDENT   \t\t\t\t\t|");
		System.out.println();
		for (int i = 0; i < 97; i++){
			System.out.print("-");
		}
		System.out.print("\n\n\n");
		int c=0,q=0,g=0;
		do{
			boolean validateid;
			int inId;
			String id;
			l2:do{
				System.out.print("\nEnter Student ID	: ");
				id=input.nextLine();
				inId=0;
				id=idStringFormat(id);
				validateid = validateInpStuId(id);
				if (validateid){
					c=1;
				}else{
					System.out.print("not a valid id. the format should be(S001) format\n");
					c=0;
				}
			}while(c==0);
			boolean ExistsVal= searchId(id,ar,inId);
			if (!ExistsVal){
				System.out.println("\nAlready enterd that id");
				continue;
			}
			String name;
			boolean valname;
			int z=0;
			do{
				System.out.print("Enter Student Name	: ");
				name=input.nextLine();
				valname=validateNameNull(name);
				if (valname){
					z=1;
				}else{
					System.out.println("please enter the Name\n");
				}
			} while(z==0);
			
			
			int inName=1;
			int inPRF=2;
			int inDBMS=3;
			if (validateid && ExistsVal){
				ar=incrementAr(ar);
				ar=addToArray(ar,inId,id);
				ar=addToArray(ar,inName,name);
				ar=addToArray(ar,inPRF,"-1");
				ar=addToArray(ar,inDBMS,"-1");

				System.out.print("\n\nStudent has been added successfully. ");
			}
			do{
				System.out.print("Do you want to add a new student (y/n): ");
				String r=input.nextLine();
				int[] limit = {65,122};
				boolean check = checkInpYN(r,limit);
				if (check){
					r=formatYN(r);
					if (r.equals("Y")){
						q=0;
						g=0;
					}else{
						q=1;
						home(ar);
					}
				}else{
					System.out.println("wrong input");
					q=0;
					g=1;
				}
			}while(g==1);
		}while(q==0);
		return ar;
	}
	public static String[][] ansWithMarks(String[][] ar){
		clearConsole();
		Scanner input=new Scanner(System.in);
		for (int i = 0; i < 97; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.print("|\t\t\t\t    ADD NEW STUDENT WITH MARKS    \t\t\t\t|");
		System.out.println();
		for (int i = 0; i < 97; i++){
			System.out.print("-");
		}
		System.out.print("\n\n\n");
		int c=0,q=0,g=0;
		do{
			boolean validateid;
			int inId;
			String id;
			do{
				System.out.print("\nEnter Student ID	: ");
				id=input.nextLine();
				inId=0;
				id=idStringFormat(id);
				validateid = validateInpStuId(id);
				if (validateid){
					c=1;
				}else{
					System.out.println("not a valid id. the format should be(S001) format");
					c=0;
				}
			}while(c==0);
			boolean ExistsVal= searchId(id,ar,inId);
			if (!ExistsVal){
				System.out.println("\nAlready enterd that id");
				continue;
			}
			String name;
			boolean valname;
			int z=0;
			do{
				System.out.print("Enter Student Name	: ");
				name=input.nextLine();
				valname=validateNameNull(name);
				if (valname){
					z=1;
				}else{
					System.out.println("please enter the name\n");
				}
			} while(z==0);
			String prf;
			String dbms;
			int p=0;
			do{
				System.out.print("Enter Student PRF mark	: ");
				prf=input.nextLine();
				boolean prfMCheck=validateMarks(prf);
				if (prfMCheck){
					p=1;
				}
			}while(p==0);
			p=0;
			do{
				System.out.print("Enter Student DBMS mark	: ");
				dbms=input.nextLine();
				boolean prfMCheck=validateMarks(dbms);
				if (prfMCheck){
					p=1;
				}
			}while(p==0);
			int inName=1;
			int inPRF=2;
			int inDBMS=3;
			if (validateid && ExistsVal){
				ar=incrementAr(ar);
				ar=addToArray(ar,inId,id);
				ar=addToArray(ar,inName,name);
				ar=addToArray(ar,inPRF,prf);
				ar=addToArray(ar,inDBMS,dbms);
				System.out.print("\n\nStudent has been added successfully.");
			}
			do{
				System.out.print(" Do you want to add a new student (y/n): ");
				String r=input.nextLine();
				int[] limit = {65,122};
				boolean check = checkInpYN(r,limit);
				if (check){
					r=formatYN(r);
					if (r.equals("Y")){
						q=0;
						g=0;
					}else{
						q=1;
						home(ar);
					}
				}else{
					System.out.println("wrong input");
					q=0;
					g=1;
				}
			}while(g==1);
		}while(q==0);
		return ar;
		
	}
	public static String[][] addMarks(String[][] ar){
		clearConsole();
		Scanner input=new Scanner(System.in);
		for (int i = 0; i < 97; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.print("|\t\t\t\t\t    ADD MARKS    \t\t\t\t\t|");
		System.out.println();
		for (int i = 0; i < 97; i++){
			System.out.print("-");
		}
		System.out.print("\n\n\n");
		int c=0,q=0,g=0;
		do{
			boolean validateid;
			int inId;
			int idl;
			int inName=1;
			int inPRF=2;
			int inDBMS=3;
			String id;
			do{
				System.out.print("\nEnter Student ID	: ");
				id=input.nextLine();
				inId=0;
				
				id=idStringFormat(id);
				boolean ExistsValar;
				validateid = validateInpStuId(id);
				if (validateid){
					ExistsValar= searchId(id,ar,inId);
					if (!ExistsValar){
						idl=idLocation(id,ar,inId);
						boolean ExistsVal= searchId(id,ar,inId);
						System.out.println("Student name: "+ar[inName][idl]);
						if (!ar[inPRF][idl].equals("-1")){
								System.out.println("This Student's marks have been already added.\nIf you want to update the marks, Please use [5] Update Marks option. \n");
								c=0;
								break;
							}
						c=1;
						int p=0;
						String prf;
						String dbms;
						do{
							System.out.print("Enter Student PRF mark	: ");
							prf=input.nextLine();
							boolean prfMCheck=validateMarks(prf);
							if (prfMCheck){
								p=1;
							}
						}while(p==0);
						p=0;
						do{
							System.out.print("Enter Student DBMS mark	: ");
							dbms=input.nextLine();
							boolean prfMCheck=validateMarks(dbms);
							if (prfMCheck){
								p=1;
							}
						}while(p==0);
						if (validateid && !ExistsVal){
							if (ar[inPRF][idl].equals("-1")){
								ar=addToArraywithid(ar,inPRF,prf,idl);
								ar=addToArraywithid(ar,inDBMS,dbms,idl);
								System.out.print("\nMarks have been added. ");
								}else{
								System.out.println("you only can add values");
								c=1;
							}
						}
					}else{
						System.out.print("Invalid Student ID.");
						break;
					}
				}else{
					System.out.println("not a valid id. the format should be(S001) format");
					c=0;
				}
			}while(c==0);
			do{
				boolean ExistsValar= searchId(id,ar,inId);
				if (ExistsValar){
					System.out.print("Do you want to search again? (Y/n): ");
				}else{
					System.out.print("Do you want to add marks for another student? (Y/n): ");
				}
				String r=input.nextLine();
				int[] limit = {65,122};
				boolean check = checkInpYN(r,limit);
				if (check){
					r=formatYN(r);
					if (r.equals("Y")){
						q=0;
						g=0;
					}else{
						q=1;
						home(ar);
					}
				}else{
					System.out.println("wrong input");
					q=0;
					g=1;
				}
			}while(g==1);	
			
		}while(q==0);
		return ar;
	}
	
	public static String[][] updateStuDtl(String[][] ar){
		clearConsole();
		Scanner input=new Scanner(System.in);
		for (int i = 0; i < 97; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.print("|\t\t\t\t\tUPDATE STUDENT DETAILS\t\t\t\t\t|");
		System.out.println();
		for (int i = 0; i < 97; i++){
			System.out.print("-");
		}
		System.out.print("\n\n\n");
		int c=0,q=0,g=0;
		do{
			boolean validateid;
			int inId;
			int idl;
			int inName=1;
			int inPRF=2;
			int inDBMS=3;
			String id;
			do{
				System.out.print("\nEnter Student ID	: ");
				id=input.nextLine();
				inId=0;
				
				id=idStringFormat(id);
				boolean ExistsValar;
				validateid = validateInpStuId(id);
				if (validateid){
					ExistsValar= searchId(id,ar,inId);
					if (!ExistsValar){
						idl=idLocation(id,ar,inId);
						boolean ExistsVal= searchId(id,ar,inId);
						System.out.println("Student name: "+ar[inName][idl]);
						System.out.print("\nEnter the new student name	: ");
						String name=input.nextLine();
						if (validateid && !ExistsVal){
							ar=addToArraywithid(ar,inName,name,idl);
							System.out.print("\nStudent details has been updated successfully.\n");
							c=1;
						}
					}else{
						System.out.println("\nThis student isn't added previousely. \nIf you want to Add a student, \nPlease use [1] Add New Student option or [2] Add new student with marks option. ");
						c=1;
					}
				}else{
					System.out.println("not a valid id. the format should be(S001) format");
					c=0;
				}
			}while(c==0);
			do{
				boolean ExistsValar= searchId(id,ar,inId);
				if (ExistsValar){
					System.out.print("Do you want to search again? (Y/n): ");
				}else{
					System.out.print("Do you want to update another student detail? (Y/n): ");
				}
				String r=input.nextLine();
				int[] limit = {65,122};
				boolean check = checkInpYN(r,limit);
				if (check){
					r=formatYN(r);
					if (r.equals("Y")){
						q=0;
						g=0;
					}else{
						q=1;
						home(ar);
					}
				}else{
					System.out.println("wrong input");
					q=0;
					g=1;
				}
			}while(g==1);	
			
		}while(q==0);
		return ar;
	}
	public static String[][] updateMarks(String[][] ar){
		clearConsole();
		Scanner input=new Scanner(System.in);
		for (int i = 0; i < 97; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.print("|\t\t\t\t\t    UPDATE MARKS    \t\t\t\t\t|");
		System.out.println();
		for (int i = 0; i < 97; i++){
			System.out.print("-");
		}
		System.out.println();
		int c=0,q=0,g=1,h=0;
		boolean added=true;
		do{
			boolean validateid;
			boolean ExistsValarsa;
			int inId;
			int idl;
			int inName=1;
			int inPRF=2;
			int inDBMS=3;
			String id;
			do{
				System.out.print("\n\n\nEnter Student ID	: ");
				id=input.nextLine();
				inId=0;
				
				id=idStringFormat(id);
				validateid = validateInpStuId(id);
				if (validateid ){
					ExistsValarsa= searchId(id,ar,inId);
					if (!ExistsValarsa){
						idl=idLocation(id,ar,inId);
						boolean ExistsVal= searchId(id,ar,inId);
						System.out.println("Student name: "+ar[inName][idl]);
						if (ar[inPRF][idl].equals("-1")){
								System.out.println("\nThis Student's marks yat to be added.\nIf you want to add marks, Please use [3] Add Marks option. \n");
								added=false;
								c=0;
								break ;
						}
						System.out.println("\nProgramming Fundimantals Mark	: "+ar[inPRF][idl]);
						System.out.println("Database Management System Mark	: "+ar[inDBMS][idl]);
						c=1;
						System.out.print("Enter Student PRF marks 	: ");
						String prf=input.nextLine();
						System.out.print("Enter Student DBMS marks	: ");
						String dbms=input.nextLine();
						if (validateid & !ExistsValarsa & !ar[inPRF][idl].equals("-1")){
							ar=addToArraywithid(ar,inPRF,prf,idl);
							ar=addToArraywithid(ar,inDBMS,dbms,idl);
							System.out.print("\n\nStudent's marks has been updated successfully.\n");
						}
					}else{
							System.out.print("This student isn't added previousely. If you want to Add a student, \nPlease use [1] Add New Student option or [2] Add new student with marks option. \n\n");
							c=1;
					}
				}else{
					System.out.print("not a valid id. the format should be(S001) format");
					c=0;
				}
			}while(c==0);
			do{
				ExistsValarsa= searchId(id,ar,inId);
				if (!ExistsValarsa&added){
					System.out.print("Do you want to update marks for another student? (y/n): ");
				}else{
					System.out.print("Do you want to search again? (y/n): ");
				}
				String r=input.nextLine();
				int[] limit = {65,122};
				boolean check = checkInpYN(r,limit);
				if (check){
					r=formatYN(r);
					if (r.equals("Y")){
						q=0;
						h=0;
					}else{
						q=1;
						home(ar);
					}
				}else{
					System.out.println("wrong input");
					q=0;
					h=1;
				}
			}while(h==1);	
		}while(q==0);
		return ar;
	}
	public static String[][] deleteStudent(String[][] ar){
		clearConsole();
		Scanner input=new Scanner(System.in);
		for (int i = 0; i < 97; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.print("|\t\t\t\t\t    DELETE STUDENT    \t\t\t\t\t|");
		System.out.println();
		for (int i = 0; i < 97; i++){
			System.out.print("-");
		}
		System.out.print("\n\n\n");
		int c=0,q=0,g=0;
		boolean ExistsVal= false;
		do{
			boolean validateid;
			int inId;
			int idl;
			int inName=1;
			int inPRF=2;
			int inDBMS=3;
			String id;
			do{
				System.out.print("\nEnter Student ID	: ");
				id=input.nextLine();
				inId=0;
				
				id=idStringFormat(id);
				validateid = validateInpStuId(id);
				if (validateid ){
					idl=idLocation(id,ar,inId);
					ExistsVal= searchId(id,ar,inId);
					c=1;
					if (validateid && !ExistsVal){
						ar=decrementAr(ar,idl);
						System.out.print("Student has been deleted successfully. ");
					}
				}else{
					System.out.println("not a valid id. the format should be(S001) format");
					c=0;
				}
			}while(c==0);
			do{
				if (!ExistsVal){
					System.out.print("\nDo you want to delete another student? (y/n): ");
				}else{
					System.out.print("ID that you search does not exists. \nDo you want to search again? (y/n): ");
				}
				String r=input.nextLine();
				int[] limit = {65,122};
				boolean check = checkInpYN(r,limit);
				if (check){
					r=formatYN(r);
					if (r.equals("Y")){
						q=0;
						g=0;
					}else{
						q=1;
						home(ar);
					}
				}else{
					System.out.println("\nwrong input");
					q=0;
					g=1;
				}
			}while(g==1);
		}while(q==0);
		return ar;
	}
	public static void printStuDetails(String[][] ar){
		clearConsole();
		Scanner input=new Scanner(System.in);
		for (int i = 0; i < 97; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.print("|\t\t\t\t\tPRINT STUDENT DETAILS\t\t\t\t\t|");
		System.out.println();
		for (int i = 0; i < 97; i++){
			System.out.print("-");
		}
		System.out.print("\n\n");
		int c=0,q=0,g=0;
		do{
			boolean validateid;
			boolean ExistsValarsa;
			int inId;
			int idl;
			int inName=1;
			int inPRF=2;
			int inDBMS=3;
			String id;
			do{
				System.out.print("\nEnter Student ID	: ");
				id=input.nextLine();
				inId=0;
				id=idStringFormat(id);
				validateid = validateInpStuId(id);
				ExistsValarsa= searchId(id,ar,inId);
				int searchIDLocation = idLocation(id,ar,inId);
				//System.out.println(searchIDLocation);
				if (validateid ){
					if (!ExistsValarsa && ar[inPRF][searchIDLocation].equals("-1")){
						idl=idLocation(id,ar,inId);
						System.out.println("Student name: "+ar[inName][idl]);
						System.out.println("This Student's marks yat to be added.\nIf you want to add marks, Please use [3] Add Marks option. \n");
						//added=false;
						c=0;
						break ;
					}
					if (!ExistsValarsa){
						idl=idLocation(id,ar,inId);
						boolean ExistsVal= searchId(id,ar,inId);
						System.out.println("Student name: "+ar[inName][idl]);
						boolean desimalcheck=desimalCheck(ar,idl);
						//System.out.println(desimalcheck);
						System.out.print("+");
						for (int i = 0; i < 39; i++){
							System.out.print("-");
						}
						System.out.print("+");
						for (int i = 0; i < 20; i++){
							System.out.print("-");
						}
						System.out.print(desimalcheck ? "---":"");
						System.out.print("+");
						//float tot=totalINSTD(ar,idl);
						if (desimalcheck){
							System.out.print("\n| Programming Fundimantals Marks	|		"+(totalINSTD(ar,idl)>99 ? "   ":"   "));
							System.out.printf("%.2f",Float.parseFloat(ar[inPRF][idl]));
							System.out.print("|");
							System.out.print("\n| Database management System Marks	|		"+(totalINSTD(ar,idl)>99 ? "   ":"   "));
							System.out.printf("%.2f",Float.parseFloat(ar[inDBMS][idl]));
							System.out.print("|");
							System.out.printf("\n| Total Marks				|		"+(totalINSTD(ar,idl)>99 ? "  ":"   "));
							System.out.printf("%.2f",totalINSTD(ar,idl));
							System.out.print("|");
							System.out.print("\n| Avg. Marks				|	 	"+(totalINSTD(ar,idl)>99 ? "   ":"   "));
							System.out.printf("%.2f",averageINSTD(ar,idl));
							System.out.print("|");
							System.out.print("\n| Rank					|	    "+(rankINSTD(ar,idl)==1 ? "   ":rankINSTD(ar,idl)==ar[0].length ? "    ":rankINSTD(ar,idl)==2 ? "  ":rankINSTD(ar,idl)==3 ? "   ":"\t       ")+rankINSTD(ar,idl)+(rankINSTD(ar,idl)==1 ? " (First)":rankINSTD(ar,idl)==ar[0].length ? " (Last)":rankINSTD(ar,idl)==2 ? " (Second)":rankINSTD(ar,idl)==3 ? " (Third)":"")+"|\n");
						}else{
							System.out.print("\n| Programming Fundimantals Marks	|		"+(totalINSTD(ar,idl)>99 ? "   ":"   ")+ar[inPRF][idl]+"|");
							System.out.print("\n| Database management System Marks	|		"+(totalINSTD(ar,idl)>99 ? "   ":"   ")+ar[inDBMS][idl]+"|");
							System.out.printf("\n| Total Marks				|		"+(totalINSTD(ar,idl)>99 ? "  ":"   ")+totalINSTDint(ar,idl)+"|");
							System.out.print("\n| Avg. Marks				|	 	"+(totalINSTD(ar,idl)>99 ? " ":" ")+averageINSTD(ar,idl)+"|");
							System.out.print("\n| Rank					|	    "+(rankINSTD(ar,idl)==1 ? "":rankINSTD(ar,idl)==ar[0].length ? " ":rankINSTD(ar,idl)==2 ? "\b":rankINSTD(ar,idl)==3 ? "":"\t    ")+rankINSTD(ar,idl)+(rankINSTD(ar,idl)==1 ? " (First)":rankINSTD(ar,idl)==ar[0].length ? " (Last)":rankINSTD(ar,idl)==2 ? " (Second)":rankINSTD(ar,idl)==3 ? " (Third)":"")+"|\n");
						}
						System.out.print("+");
						for (int i = 0; i < 39; i++){
							System.out.print("-");
						}
						System.out.print("+");
						for (int i = 0; i < 20; i++){
							System.out.print("-");
						}
						System.out.print(desimalcheck ? "---":"");
						System.out.print("+");
						System.out.println();
						c=1;
					}else{
							System.out.print("This student isn't added previousely. If you want to Print student Details, \nPlease enter the student data from [1] Add New Student option or [2] Add new student with marks option. \n\n");
							c=1;
					}
				}else{
					System.out.println("not a valid id. the format should be(S001) format");
					c=0;
				}
			}while(c==0);
			do{
				ExistsValarsa= searchId(id,ar,inId);
				if (!ExistsValarsa){
					System.out.print("\nDo you want to search another student details ? (Y/n): ");
				}else{
					System.out.print("Do you want to go back to main menu? (Y/n): ");
					String r=input.nextLine();
					int[] limit = {65,122};
					boolean check = checkInpYN(r,limit);
					if (check){
						r=formatYN(r);
						if (r.equals("Y")){
							q=1;
							home(ar);
						}else{
							q=0;
							g=1;
							break;
						}
					}else{
						System.out.println("wrong input");
						q=0;
						g=1;
					}
				}
				String r=input.nextLine();
				int[] limit = {65,122};
				boolean check = checkInpYN(r,limit);
				if (check){
					r=formatYN(r);
					if (r.equals("Y")){
						q=0;
						g=0;
					}else{
						q=1;
						home(ar);
					}
				}else{
					System.out.println("wrong input");
					q=0;
					g=1;
				}
			}while(g==1);
		}while(q==0);
	}
	public static void printStudentRank(String[][] ar){
		clearConsole();
		Scanner input=new Scanner(System.in);
		for (int i = 0; i < 97; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.print("|\t\t\t\t\tPRINT STUDENT RANK\t\t\t\t\t|");
		System.out.println();
		for (int i = 0; i < 97; i++){
			System.out.print("-");
		}
		System.out.print("\n\n");
		int c=0,q=0,g=0;
		do{
			boolean validateid;
			boolean ExistsValarsa;
			int inId=0;
			int inName=1;
			int inPRF=2;
			int inDBMS=3;
			String id;
			int[] ranks = rankINSTDescId(ar,100);
			int[] kal = rankINSTDescIdodr(ar,100);
			System.out.print("+");
			for (int i = 0; i < 7; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 7; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 31; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 15; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 15; i++){
				System.out.print("-");
			}
			System.out.print("+");
			
			System.out.println();
			System.out.print("|"+"Rank\t|");
			System.out.print("ID\t|");
			System.out.print("Name   \t\t\t|");
			System.out.print("  Total Marks  |");
			System.out.print("   Avg. Marks  |\n");
			System.out.print("+");
			for (int i = 0; i < 7; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 7; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 31; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 15; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 15; i++){
				System.out.print("-");
			}
			System.out.print("+\n");
			for (int i = 0; i < ranks.length; i++){
				int searchIDLocation = idLocation(ar[inId][ranks[i]],ar,0);
				ExistsValarsa= searchId((ar[inId][ranks[i]]),ar,0);
				if (!ExistsValarsa & !ar[inPRF][searchIDLocation].equals("-1")){
					System.out.print("|"+kal[i]+"\t|");//rankINSTD(ar,idl)//(ranks[i]+1)
					System.out.print(ar[inId][ranks[i]]+"\t|");
					System.out.print(ar[inName][ranks[i]]+"   \t\t\t|");
					System.out.print("\t"+((totalINSTD(ar,ranks[i])>99)? "  ":"   "));
					System.out.printf("%.2f",totalINSTD(ar,ranks[i]));
					System.out.print("|");
					System.out.print("\t"+((totalINSTD(ar,ranks[i])>99)? "   ":"   "));
					System.out.printf("%.2f",(totalINSTD(ar,ranks[i])/2));
					System.out.print("|\n");
				}
			}
			System.out.print("+");
			for (int i = 0; i < 7; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 7; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 31; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 15; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 15; i++){
				System.out.print("-");
			}
			System.out.print("+\n");
			do{
				System.out.print(" Do you want to go back to the main manu (y/n): ");
				String r=input.nextLine();
				int[] limit = {65,122};
				boolean check = checkInpYN(r,limit);
				if (check){
					r=formatYN(r);
					if (r.equals("Y")){
						q=1;
						home(ar);
					}else{
						q=0;
						g=0;
					}
				}else{
					System.out.println("wrong input");
					q=0;
					g=1;
				}
			}while(g==1);
		}while(q==0);
	}
	public static void BestInPrf(String[][] ar){
		clearConsole();
		Scanner input=new Scanner(System.in);
		for (int i = 0; i < 97; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.print("|\t\t\t\tBEST IN PROGRAMMING FUNDEMENTALS\t\t\t\t|");
		System.out.println();
		for (int i = 0; i < 97; i++){
			System.out.print("-");
		}
		System.out.print("\n\n");
		int c=0,q=0,g=0;
		do{
			boolean validateid;
			boolean ExistsValarsa;
			int inId=0;
			int inName=1;
			int inPRF=2;
			int inDBMS=3;
			String id;
			
			int[] ranks = rankINSTDescId(ar,inPRF);
			System.out.print("+");
			for (int i = 0; i < 7; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 31; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 15; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 15; i++){
				System.out.print("-");
			}
			System.out.print("+");
			
			System.out.println();
			System.out.print("|ID\t|");
			System.out.print("Name   \t\t\t|");
			System.out.print("PRF Marks\t|");
			System.out.print("DBMS Marks\t|\n");
			System.out.print("+");
			for (int i = 0; i < 7; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 31; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 15; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 15; i++){
				System.out.print("-");
			}
			System.out.print("+\n");
			boolean desimalcheck=desimalCheck(ar,1);
			if (desimalcheck){
				for (int i = 0; i < ranks.length; i++){
					int searchIDLocation = idLocation(ar[inId][ranks[i]],ar,0);
					ExistsValarsa= searchId((ar[inId][ranks[i]]),ar,0);
					if (!ExistsValarsa & !ar[inPRF][searchIDLocation].equals("-1")){
						System.out.print("|");
						System.out.print(ar[inId][ranks[i]]+"\t|");
						System.out.print(ar[inName][ranks[i]]+"   \t\t\t|");
						System.out.printf("%.2f",Float.parseFloat(ar[inPRF][ranks[i]]));
						System.out.print("\t\t|");
						System.out.printf("%.2f",Float.parseFloat(ar[inDBMS][ranks[i]]));
						System.out.print("\t\t|\n");
					}
				}
			}else{
				for (int i = 0; i < ranks.length; i++){
					int searchIDLocation = idLocation(ar[inId][ranks[i]],ar,0);
					ExistsValarsa= searchId((ar[inId][ranks[i]]),ar,0);
					if (!ExistsValarsa & !ar[inPRF][searchIDLocation].equals("-1")){
						System.out.print("|");
						System.out.print(ar[inId][ranks[i]]+"\t|");
						System.out.print(ar[inName][ranks[i]]+"   \t\t\t|");
						System.out.print(ar[inPRF][ranks[i]]+"\t\t|");
						System.out.print(ar[inDBMS][ranks[i]]+"\t\t|\n");
					}
				}
			}
			System.out.print("+");
			for (int i = 0; i < 7; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 31; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 15; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 15; i++){
				System.out.print("-");
			}
			System.out.print("+\n");
			do{
				System.out.print(" Do you want to go back to the main manu (y/n): ");
				String r=input.nextLine();
				int[] limit = {65,122};
				boolean check = checkInpYN(r,limit);
				if (check){
					r=formatYN(r);
					if (r.equals("Y")){
						q=1;
						home(ar);
					}else{
						q=0;
						g=0;
					}
				}else{
					System.out.println("wrong input");
					q=0;
					g=1;
				}
			}while(g==1);
		}while(q==0);
	}
	public static void bestInDbms(String[][] ar){
		clearConsole();
		Scanner input=new Scanner(System.in);
		for (int i = 0; i < 97; i++){
			System.out.print("-");
		}
		System.out.println();
		System.out.print("|\t\t\t\tBEST IN DATABASE MANAGEMENT SYSTEM\t\t\t\t|");
		System.out.println();
		for (int i = 0; i < 97; i++){
			System.out.print("-");
		}
		System.out.print("\n\n");
		int c=0,q=0,g=0;
		do{
			boolean validateid;
			boolean ExistsValarsa;
			int inId=0;
			int inName=1;
			int inPRF=2;
			int inDBMS=3;
			String id;
			
			int[] ranks = rankINSTDescId(ar,inDBMS);
			System.out.print("+");
			for (int i = 0; i < 7; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 31; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 15; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 15; i++){
				System.out.print("-");
			}
			System.out.print("+");
			System.out.println();
			System.out.print("|ID\t|");
			System.out.print("Name   \t\t\t|");
			System.out.print("DBMS Marks\t|");
			System.out.print("PRF Marks\t|\n");
			System.out.print("+");
			for (int i = 0; i < 7; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 31; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 15; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 15; i++){
				System.out.print("-");
			}
			System.out.print("+\n");
			boolean desimalcheck=desimalCheck(ar,1);
			if (desimalcheck){
				for (int i = 0; i < ranks.length; i++){
					int searchIDLocation = idLocation(ar[inId][ranks[i]],ar,0);
					ExistsValarsa= searchId((ar[inId][ranks[i]]),ar,0);
					if (!ExistsValarsa & !ar[inPRF][searchIDLocation].equals("-1")){
						System.out.print("|");
						System.out.print(ar[inId][ranks[i]]+"\t|");
						System.out.print(ar[inName][ranks[i]]+"   \t\t\t|");
						System.out.printf("%.2f",Float.parseFloat(ar[inDBMS][ranks[i]]));
						System.out.print("\t\t|");
						System.out.printf("%.2f",Float.parseFloat(ar[inPRF][ranks[i]]));
						System.out.print("\t\t|\n");
					}
				}
			}else{
				for (int i = 0; i < ranks.length; i++){
					int searchIDLocation = idLocation(ar[inId][ranks[i]],ar,0);
					ExistsValarsa= searchId((ar[inId][ranks[i]]),ar,0);
					if (!ExistsValarsa & !ar[inPRF][searchIDLocation].equals("-1")){
						System.out.print("|");
						System.out.print(ar[inId][ranks[i]]+"\t|");
						System.out.print(ar[inName][ranks[i]]+"   \t\t\t|");
						System.out.print(ar[inDBMS][ranks[i]]+"\t\t|");
						System.out.print(ar[inPRF][ranks[i]]+"\t\t|\n");
					}
				}
			}
			System.out.print("+");
			for (int i = 0; i < 7; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 31; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 15; i++){
				System.out.print("-");
			}
			System.out.print("+");
			for (int i = 0; i < 15; i++){
				System.out.print("-");
			}
			System.out.print("+\n");
			do{
				System.out.print(" Do you want to go back to the main manu (y/n): ");
				String r=input.nextLine();
				int[] limit = {65,122};
				boolean check = checkInpYN(r,limit);
				if (check){
					r=formatYN(r);
					if (r.equals("Y")){
						q=1;
						home(ar);
					}else{
						q=0;
						g=0;
					}
				}else{
					System.out.println("wrong input");
					q=0;
					g=1;
				}
			}while(g==1);
		}while(q==0);
	}
	public static void main(String args[]){
		String[][] ar = new String[4][0];
		ar=home(ar);
	}
}

