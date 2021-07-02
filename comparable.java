public class comparable  {
    public static void main(String[] args) {
        Person person1 = new Person(17,"aaa");
        Person person2 = new Person(19,"ccc");
        Person person3 = new Person(18,"bbb");

        Comparable compara = compara(person2, person3);
        System.out.println(compara);

    }

    public static Comparable compara(Comparable c1,Comparable c2){//接口做形参，传入对象实现（父类做形参传入子类，多态写法）

        int i = c1.compareTo(c2);
        if(i>=0){
            return c1;
        }else {
            return c2;
        }
    }
}
