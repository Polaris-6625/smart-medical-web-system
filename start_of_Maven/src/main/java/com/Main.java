package com;


import java.io.*;
import java.util.Scanner;

public class Main {
    static employee[] empAll = new employee[1000];
    static int flag = 0;
    public static void main(String[] args){
        while (true){
            System.out.println("ְ��ϵͳ");
            System.out.println("1---���빦��");
            System.out.println("2---��ѯ����");
            System.out.println("3---������");
            System.out.println("4---�޸Ĺ���");
            System.out.println("5---ɾ������");
            System.out.println("6---�˳�ϵͳ");
            System.out.println("7---���ú�̨");
            System.out.println("8---����ͳ��");
            System.out.println("����������ѡ��");
            int choice = 0;
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            if(choice == 1){
                readold();
                InPut();
                toWrite();
                System.out.println("¼�����");
            }
            if(choice == 2){
                readold();
                System.out.println("1--������ѯ");
                System.out.println("2---���Ҳ�ѯ");
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
        System.out.println("��ӭʹ��ͳ�ƹ���");
        System.out.println("������Ҫͳ�ƵĿ���");
        String ck = scanner.next();
        i = 0;
        int j = 0;
        for(i=0;i<flag;i++){
            if(ALLkwhere[i].equals(ck)){
                index[j] = i;
                j++;
            }

        }
        System.out.println("���ҵĹ�������:");
        int k =0;
        for(;k<j;k++){
            System.out.println(empAll[index[k]].getMoney().toString());
        }
        System.out.println("�ÿ��ҵ�ƽ��������");
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
        System.out.println("�������");
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
        System.out.println("������Ҫ�޸ĵĹ���");
        String cGNumber = scanner.next();
        i = 0;
        for(String it:allGNumber){
            if(cGNumber.equals(it)){
                System.out.println("�ҵ��˴��޸ĵ�Ԫ��");
                index = i;
            }
            else {
                i++;
            }
        }
        if(index==-1){
            System.out.println("�޸�ʧ�ܣ�Ҫ�޸ĵĹ��Ų�����");
        }
        else {
            System.out.println("�����������޸ĺ��Ա����Ϣ");
            System.out.println("������ְ��������");
            String name = scanner.next();
            System.out.println("������ְ�����Ա�");
            String sex = scanner.next();
            System.out.println("������ְ�������֤����");
            String ID = scanner.next();
            System.out.println("������ְ���ĳ�������");
            String startDay = scanner.next();
            employee emp = new employee(name,sex,ID,startDay);
            System.out.println("������ְ���Ĺ���");
            String gNumber = scanner.next();
            System.out.println("������ְ���ĵ绰");
            String telNumber = scanner.next();
            System.out.println("������ְ���Ŀ���");
            String kWhere = scanner.next();
            System.out.println("������ְ���Ĺ���");
            String money = scanner.next();
            emp.setgNumber(gNumber);
            emp.setTelNumber(telNumber);
            emp.setkWhere(kWhere);
            emp.setStartDay(startDay);
            emp.setMoney(money);
            empAll[index] = emp;
        }
        System.out.println("�޸����");
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
        System.out.println("������Ҫɾ���Ĺ���");
        String cGNumber = scanner.next();
        i = 0;
        for(String it:allGNumber){
            if(cGNumber.equals(it)){
                System.out.println("�ҵ���ɾ����Ԫ��");
                index = i;
            }
            else {
                i++;
            }
        }
        if(index==-1){
            System.out.println("ɾ��ʧ�ܣ�Ҫ�޸ĵĹ��Ų�����");
        }
        else {
            flag--;
            int u = 0;
            for(u = index;u<flag;flag++){
                empAll[u] = empAll[u+1];
            }
            System.out.println("ɾ�����");
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
            System.out.println("����:"+empAll[n].getName()+","+"�Ա�:"+empAll[n].getSex()+","+"���֤��:"+empAll[n].getID()+","+
                    "��������:"+empAll[n].getStartDay()+","+"����:"+empAll[n].getgNumber()+","+"ְ���绰:"+empAll[n].getTelNumber()
                        +","+"ְ������:"+empAll[n].getkWhere()+","+"����:"+empAll[n].getMoney());
        }
        System.out.println("�������");
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
        System.out.println("������Ҫ��ѯ������");
        String cGName = scanner.next();
        i = 0;
        for(String it:allGName){
            if(cGName.equals(it)){
                System.out.println("��ѯ�ɹ�");
                index = i;
            }
            else {
                i++;
            }
        }
        if(index==-1){
            System.out.println("��ѯʧ��");
        }
        else {
            System.out.println("�����:");
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
        System.out.println("������Ҫ��ѯ�Ŀ���");
        String ck = scanner.next();
        i = 0;
        int j = 0;
//        for(String it:ALLkwhere){
//            if(ck.equals(it)){
//                System.out.println("��ѯ�ɹ�");
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
        System.out.println("�����:");
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
        System.out.println("��ӭ����¼��ϵͳ");
        int i = flag;
        while (true){
            System.out.println("������ְ��������");
            String name = scanner.next();
            System.out.println("������ְ�����Ա�");
            String sex = scanner.next();
            System.out.println("������ְ�������֤����");
            String ID = scanner.next();
            System.out.println("������ְ���ĳ�������");
            String startDay = scanner.next();
            employee emp = new employee(name,sex,ID,startDay);
            System.out.println("������ְ���Ĺ���");
            String gNumber = scanner.next();
            System.out.println("������ְ���ĵ绰");
            String telNumber = scanner.next();
            System.out.println("������ְ���Ŀ���");
            String kWhere = scanner.next();
            System.out.println("������ְ���Ĺ���");
            String money = scanner.next();
            emp.setgNumber(gNumber);
            emp.setTelNumber(telNumber);
            emp.setkWhere(kWhere);
            emp.setStartDay(startDay);
            emp.setMoney(money);
            empAll[i] = emp;
            i++;
            flag = i;
            System.out.println("�Ƿ��������");
            int ch = 0;
            System.out.println("1----��������\t2----ֹͣ����");
            ch = scanner.nextInt();
            if(ch == 2){
                break;
            }
        }
    }
}
