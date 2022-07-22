package com.KoreaIT.java.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.KoreaIT.java.BAM.controller.ArticleController;
import com.KoreaIT.java.BAM.controller.Controller;
import com.KoreaIT.java.BAM.controller.MemberController;
import com.KoreaIT.java.BAM.dto.Article;
import com.KoreaIT.java.BAM.dto.Member;
import com.KoreaIT.java.BAM.util.Util;

public class App {	
		
		public void run() {
			System.out.println("==프로그램 시작==");
			
			Scanner sc = new Scanner(System.in);
			
			MemberController memberController = new MemberController(sc);
			ArticleController articleController = new ArticleController(sc);
			
			articleController.makeTestData();
			
			
			while (true) {
				System.out.printf("명령어 ) ");
				String cmd = sc.nextLine().trim();
				if (cmd.length() == 0) {
					System.out.println("명령어를 입력해주세요");
					continue;
				}
				if (cmd.equals("exit")) {
					break;
				}
				
				String[] cmdBits = cmd.split(" ");
				
				if(cmdBits.length == 0) {
					System.out.println("명령어를 확인해 주세요");
					continue;
				}
				
				String controllerName = cmdBits[0];
//				String actionMethodName = cmdBits[1];
				
				Controller controller = null;
				
				if(controllerName.equals("article")) {
					controller = articleController;
				}else if(controllerName.equals("member")) {
					controller = memberController;
				}else {
					System.out.println("존재하지 않는 명령어 입니다.");
					continue;
				}
				
				controller.doAction(cmd);
				
//				if (cmd.equals("member join")) {					
//					memberController.doJoin(members ,sc);						
//				} else if (cmd.equals("article write")) {
//					articleController.doWrite();					
//				} else if (cmd.startsWith("article list")) {
//					articleController.showList();					
//				} else if (cmd.startsWith("article detail ")) {
//					articleController.showDetail);							
//				} else if (cmd.startsWith("article modify ")) {
//					articleController.doModfy();										
//				} else if (cmd.startsWith("article delete ")) {
//					articleController.doDelete();					
//				} else {
//					System.out.println("존재하지 않는 명령어입니다");
//				}
			}
			System.out.println("==프로그램 끝==");
			sc.close();
		}		

		
		
	}
			