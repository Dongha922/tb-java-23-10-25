package com.ll;

import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {
    Scanner scanner;
    int index;
    List<Quotation> quotations;

    //명어 넣을 배열 객체 한개 만들기
    //가변크기로 만들기
    App() {
        scanner = new Scanner(System.in);
        index = 0;
        quotations = new ArrayList<>();
    }

    void run() {
        System.out.println("===명언앱 ===");
        while (true) {
            System.out.printf("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                //함수선언
                actionWrite();
            } else if (cmd.equals("목록")) {
                actionList();
            } else if (cmd.startsWith("삭제?")) {
                actionRemove(cmd);
            } else if (cmd.startsWith("수정?")) {
                actionModify(cmd);

            }
        }
    }

    //등록
    void actionWrite() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String authorName = scanner.nextLine();

        index++;
        int id = index;

        Quotation quotation = new Quotation(id, content, authorName);
        quotations.add(quotation);
        System.out.println(id + "번 명언이 등록되었습니다.");

    }

    //목록
    void actionList() {
        System.out.println("번호 / 작가 / 명언");

        System.out.println("---------------------");
        if (quotations.isEmpty())
            System.out.println("등록된 명언이 없습니다");
        for (int i = quotations.size() - 1; i >= 0; i--) {
            Quotation quotation = quotations.get(i);

            System.out.printf("%d / %s / %s\n", quotation.id, quotation.authorName, quotation.content);
        }
    }

    //삭제
    void actionRemove(String cmd) {
        //뽑을 인덱스
        //삭제?id=5&archive=true
        //?를 기준으로 명령어와 인덱스를 나눈다
        //cmdBits배열에 넣어 관리한다. 삭제 // id=5&a  rchive=true
        String[] cmdBits = cmd.split("\\?",2);
        String action = cmdBits[0];
        String queryString =  cmdBits[1];

        //queryStringBits 배열에 &기준으로 분리
        //id=5 / archive=true
        String[] queryStringBits= queryString.split("&");

        //?
        int id =0;
        for (int i = 0; i < queryStringBits.length; i++) {
            String queryParamStr =queryStringBits[i];
            // id / 5/ archive= true
            String[] queryParamStrBits =queryParamStr.split("=",2);

            String paramName= queryParamStrBits[0];// id
            String paramValue =queryParamStrBits[1]; //5

            if(paramName.equals("id"))
            {
                id=Integer.parseInt(paramValue);
            }
        }
        System.out.println(id + "번 명언을 삭제합니다.");


    }
    void actionModify(){
        System.out.println(id+"번 명언을 수정핮니다");

    }
}