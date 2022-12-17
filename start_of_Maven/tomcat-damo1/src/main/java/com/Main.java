package com;


import java.io.*;
import java.util.Scanner;

public class Main {
    static employee[] empAll = new employee[1000];
    static int flag = 0;
    public static void main(String[] args){
        while (true){
            System.out.println("职工系统");
            System.out.println("1---输入功能");
            System.out.println("2---查询功能");
            System.out.println("3---排序功能");
            System.out.println("4---修改功能");
            System.out.println("5---删除功能");
            System.out.println("6---退出系统");
            System.out.println("7---重置后台");
            System.out.println("8---工资统计");
            System.out.println("请输入您的选择");
            int choice = 0;
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            if(choice == 1){
                readold();
                InPut();
                toWrite();
                System.out.println("录入完毕");
            }
            if(choice == 2){
                readold();
                System.out.println("1--姓名查询");
                System.out.println("2---科室查询");
                int c = 0;
                c=scanner.nextInt();
                if(c==1){
                    search_1();
                }
                if (c==2){
                    search_2();
                }
            }
            if(choice == 3){
                readold();
                sort();
            }
            if(choice == 4){
                readold();
                change();
                toWrite();
            }
            if (choice == 5){
                readold();
                del();
                toWrite();
            }
            if(choice == 6){
                break;
            }
            if(choice == 7){
                clearAll();
            }
            if(choice == 8){
                readold();
                tJall();
            }
        }

    }
    public static void tJall(){

        int[] index = new int[1000];
        String result = null;
        String[] ALLkwhere = new String[1000];
        int i = 0;
        for(;i<flag;i++){
            ALLkwhere[i] = empAll[i].getkWhere();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎使用统计功能");
        System.out.println("请输入要统计的科室");
        String ck = scanner.next();
        i = 0;
        int j = 0;
        for(i=0;i<flag;i++){
            if(ALLkwhere[i].equals(ck)){
                index[j] = i;
                j++;
            }

        }
        System.out.println("科室的工资如下:");
        int k =0;
        for(;k<j;k++){
            System.out.println(empAll[index[k]].getMoney().toString());
        }
        System.out.println("该科室的平均工资是");
        int x = 0;
        int All = 0;
        for(;x<j;x++){
            int y = Integer.parseInt(empAll[index[x]].getMoney());
            All+=y;
        }
        All/=j;
        System.out.println(All);
    }
    public static void clearAll(){
        File file = new File("z.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.write("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("重置完毕");
    }
    public static void change(){
        int index = -1;
        String result = null;
        String[] allGNumber = new String[1000];
        int i = 0;
        for(;i<flag;i++){
            allGNumber[i] = empAll[i].getgNumber();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要修改的工号");
        String cGNumber = scanner.next();
        i = 0;
        for(String it:allGNumber){
            if(cGNumber.equals(it)){
                System.out.println("找到了待修改的元素");
                index = i;
            }
            else {
                i++;
            }
        }
        if(index==-1){
            System.out.println("修改失败，要修改的工号不存在");
        }
        else {
            System.out.println("请重新输入修改后的员工信息");
            System.out.println("请输入职工的姓名");
            String name = scanner.next();
            System.out.println("请输入职工的性别");
            String sex = scanner.next();
            System.out.println("请输入职工的身份证号码");
            String ID = scanner.next();
            System.out.println("请输入职工的出生日期");
            String startDay = scanner.next();
            employee emp = new employee(name,sex,ID,startDay);
            System.out.println("请输入职工的工号");
            String gNumber = scanner.next();
            System.out.println("请输入职工的电话");
            String telNumber = scanner.next();
            System.out.println("请输入职工的科室");
            String kWhere = scanner.next();
            System.out.println("请输入职工的工资");
            String money = scanner.next();
            emp.setgNumber(gNumber);
            emp.setTelNumber(telNumber);
            emp.setkWhere(kWhere);
            emp.setStartDay(startDay);
            emp.setMoney(money);
            empAll[index] = emp;
        }
        System.out.println("修改完成");
    }
    public static void del(){
        int index = -1;
        String result = null;
        String[] allGNumber = new String[1000];
        int i = 0;
        for(;i<flag;i++){
            allGNumber[i] = empAll[i].getgNumber();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的工号");
        String cGNumber = scanner.next();
        i = 0;
        for(String it:allGNumber){
            if(cGNumber.equals(it)){
                System.out.println("找到了删除的元素");
                index = i;
            }
            else {
                i++;
            }
        }
        if(index==-1){
            System.out.println("删除失败，要修改的工号不存在");
        }
        else {
            flag--;
            int u = 0;
            for(u = index;u<flag;flag++){
                empAll[u] = empAll[u+1];
            }
            System.out.println("删除完成");
        }
    }
    public static void sort(){

        int j = 0,k = 0;
        employee[] tempEmp = new employee[1];
        String[] allMoneyNew = new String[1000];
        for(j = 0 ;j<flag-1;j++){
            for (k = 0;k<flag-1-j;k++){
                int temp1 = Integer.parseInt(empAll[k].getMoney());
                int temp2 = Integer.parseInt(empAll[k+1].getMoney());
                if(temp1 < temp2){
                    tempEmp[0] = empAll[k];
                    empAll[k] = empAll[k+1];
                    empAll[k+1] = tempEmp[0];
                }
            }
        }
        int n = 0;
        for(;n<flag;n++){
            System.out.println("姓名:"+empAll[n].getName()+","+"性别:"+empAll[n].getSex()+","+"身份证号:"+empAll[n].getID()+","+
                    "出生日期:"+empAll[n].getStartDay()+","+"工号:"+empAll[n].getgNumber()+","+"职工电话:"+empAll[n].getTelNumber()
                        +","+"职工科室:"+empAll[n].getkWhere()+","+"工资:"+empAll[n].getMoney());
        }
        System.out.println("排序完毕");
    }
    public static void readold(){
        File file = new File("z.txt");
        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileInputStream in = new FileInputStream(file);
            byte[] buy = new byte[1000];
            int len = in.read(buy);
            in.close();
            if(len!=0){
                String temp = null;
                int cnt = 0;
                while ((temp = bufferedReader.readLine()) != null){
                    String[] tempNew = temp.split(",");
                    String name = tempNew[0];
                    String sex = tempNew[1];
                    String ID = tempNew[2];
                    String startDay = tempNew[3];
                    String gNumber = tempNew[4];
                    String telNumber = tempNew[5];
                    String kWhere = tempNew[6];
                    String money = tempNew[7];
                    employee emp = new employee(name,sex,ID,startDay);
                    emp.setgNumber(gNumber);
                    emp.setTelNumber(telNumber);
                    emp.setkWhere(kWhere);
                    emp.setMoney(money);
                    empAll[cnt] = emp;
                    cnt++;
                }
                flag = cnt;
            }

            bufferedReader.close();
            fileReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void search_1(){
        int index = -1;
        String result = null;
        String[] allGName = new String[1000];
        int i = 0;
        for(;i<flag;i++){
            allGName[i] = empAll[i].getName();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查询的姓名");
        String cGName = scanner.next();
        i = 0;
        for(String it:allGName){
            if(cGName.equals(it)){
                System.out.println("查询成功");
                index = i;
            }
            else {
                i++;
            }
        }
        if(index==-1){
            System.out.println("查询失败");
        }
        else {
            System.out.println("结果是:");
            System.out.println(empAll[index].toString());
        }
    }
    public static void search_2(){

        int[] index = new int[1000];
        String result = null;
        String[] ALLkwhere = new String[1000];
        int i = 0;
        for(;i<flag;i++){
            ALLkwhere[i] = empAll[i].getkWhere();
        }
        for(i=0;i<flag;i++){
            ALLkwhere[i] = empAll[i].getkWhere();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查询的科室");
        String ck = scanner.next();
        i = 0;
        int j = 0;
//        for(String it:ALLkwhere){
//            if(ck.equals(it)){
//                System.out.println("查询成功");
//                index[j] = i;
////                System.out.println(j);
//                j++;
//            }
//            else {
//                i++;
//            }
//        }
        for(i=0;i<flag;i++){
            if(ALLkwhere[i].equals(ck)){
                index[j] = i;
                j++;
            }

        }
        System.out.println("结果是:");
        int k =0;
        for(;k<j;k++){
            System.out.println(empAll[index[k]].toString());
        }
    }
    public static void toWrite(){
        File file = new File("z.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            int k = 0;
            for(;k<flag;k++){
               bufferedWriter.write(empAll[k].toString());
               bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        }catch (IOException e ){
            e.printStackTrace();
        }
    }
    public static void InPut(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎进入录入系统");
        int i = flag;
        while (true){
            System.out.println("请输入职工的姓名");
            String name = scanner.next();
            System.out.println("请输入职工的性别");
            String sex = scanner.next();
            System.out.println("请输入职工的身份证号码");
            String ID = scanner.next();
            System.out.println("请输入职工的出生日期");
            String startDay = scanner.next();
            employee emp = new employee(name,sex,ID,startDay);
            System.out.println("请输入职工的工号");
            String gNumber = scanner.next();
            System.out.println("请输入职工的电话");
            String telNumber = scanner.next();
            System.out.println("请输入职工的科室");
            String kWhere = scanner.next();
            System.out.println("请输入职工的工资");
            String money = scanner.next();
            emp.setgNumber(gNumber);
            emp.setTelNumber(telNumber);
            emp.setkWhere(kWhere);
            emp.setStartDay(startDay);
            emp.setMoney(money);
            empAll[i] = emp;
            i++;
            flag = i;
            System.out.println("是否继续输入");
            int ch = 0;
            System.out.println("1----继续输入\t2----停止输入");
            ch = scanner.nextInt();
            if(ch == 2){
                break;
            }
        }
    }
}
