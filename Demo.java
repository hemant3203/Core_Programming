import java.util.*;

// class Student {//implements Comparable use compareTo function
//     int age;
//     String name;

//     public Student (int age,String name){
//         this.age=age;
//         this.name=name;
//     }

//     public String toString(){
//         return "Student : [age="+age +  " Name="+name+"] ";
//     }
// }
// public class Demo{
//     public static void main(String[] args) {

//          Comparator<Student> com=new Comparator<Student>()
//         {
//             public int compare(Student i,Student j){
//                 if(i.age>j.age){
//                     return 1;
//                 }
//                 else{
//                     return -1;
//                 }
//             }
//         };

//         List<String> nums=new ArrayList<>();

       

//         nums.add("455");
//         nums.add("7800");
//         nums.add("33556");
//         nums.add("29");

//         // System.out.println(nums);

//         // // Collections.sort(nums);//sort by value;
//         // // System.out.println(nums);
//         // Collections.sort(nums,com);
//         // System.out.println(nums);

//         List<Student> st=new ArrayList<>();
//         st.add(new Student(21,"op"));

//         st.add(new Student(25,"akash"));
//         st.add(new Student(23,"deepu"));
//         st.add(new Student(20,"mayank"));

//         Collections.sort(st,com);

//         for(Student s:st){
//             System.out.println(s);
//         }

        
//     }
// }


class Student implements Comparable<Student> {
    int age;
    String name;

    public Student (int age,String name){
        this.age=age;
        this.name=name;
    }

    public String toString(){
        return "Student : [age="+age +  " Name="+name+"] ";
    }

    public int compareTo(Student that){
        if(this.age>that.age){
            return 1;
        }
        else{
            return -1;
        }

    }
}

public class Demo{
    public static void main(String[] args) {

        //  Comparator<Student> com=new Comparator<Student>()
        // {
        //     public int compare(Student i,Student j){
        //         if(i.age>j.age){
        //             return 1;
        //         }
        //         else{
        //             return -1;
        //         }
        //     }
        // };

        List<String> nums=new ArrayList<>();

       

        nums.add("455");
        nums.add("7800");
        nums.add("33556");
        nums.add("29");

        // System.out.println(nums);

        // // Collections.sort(nums);//sort by value;
        // // System.out.println(nums);
        // Collections.sort(nums,com);
        // System.out.println(nums);

        List<Student> st=new ArrayList<>();
        st.add(new Student(21,"op"));

        st.add(new Student(25,"akash"));
        st.add(new Student(23,"deepu"));
        st.add(new Student(20,"mayank"));

        Collections.sort(st);

        for(Student s:st){
            System.out.println(s);
        }

        
    }
}

//Lambda function for comparator 
// Comparator<Student> com=( i, j)->i.age>j.age?1:-1;