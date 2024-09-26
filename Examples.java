interface Examples {
void learnPAPL();
void learnDS();
void manageStudies();
}




abstract class Prg implements Examples{
    public void learnPAPL(){
        System.out.println("learn java");
    }
    public void learnDS(){
        System.out.println("learn data str");
    }
}

class Student extends Prg{
    public void manageStudies(){
        System.out.println("studies");
    }
    public static void main(String[] args){
        Student s1=new Student();
        s1.learnPAPL();
        s1.learnDS();
        s1.manageStudies();
    }
}