public class Main {

    public static void main(String[] args) {
        ArrayImpl<String> arr = new ArrayImpl();
        arr.add("Hell");
        arr.add("Yeah");
        arr.add("This");
        for(int i = 0; i<5;i++){
            arr.add(String.valueOf(i));
        }
        arr.remove("This");
        System.out.println(arr.toString());
        System.out.println(arr.length());
        System.out.println(arr.contains("Hell"));
        arr.remove("Hell");
        System.out.println(arr.contains("Hell"));
        System.out.println(arr.get(2));
        arr.add("Latest");
        System.out.println(arr);
        System.out.println(arr.indexOf("Latest"));
        System.out.println(arr.size());
        ArrayImpl array = arr.clone();
        array.add("I am god");
        arr.add("No you are not");
        arr.removeAt(-1);
        System.out.println(array.toString());
        System.out.println(arr.toString());
        System.out.println(arr.isEmpty());
        arr.clear();
        System.out.println(arr.toString());

    }
}
