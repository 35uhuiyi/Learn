package test;

import SymbolTable.OrderSymbolTable;

public class SymbolTableTest {
    public static void main(String[] args) {
        OrderSymbolTable<Integer, String> tables = new OrderSymbolTable<>();
        tables.put(1,"a");
        tables.put(2,"b");
        tables.put(5,"e");

        System.out.println(tables.size());
        tables.put(3,"c");






    }
}
