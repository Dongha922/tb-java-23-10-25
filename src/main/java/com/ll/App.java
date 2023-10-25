package com.ll;

import java.util.Scanner;

class App{
    void run(){
        System.out.println("프로그램 실행");
        System.out.println("===명언앱 ===");
        System.out.printf("명령) ");

        Scanner scanner = new Scanner(System.in);
        String cmd = scanner.nextLine();

        System.out.print("입력받은 명령어 :" + cmd + "\n");
    }

}