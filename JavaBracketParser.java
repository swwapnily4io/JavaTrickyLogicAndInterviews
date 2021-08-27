package com.org.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/*
 * {
Level -1 -    Money Heist Info
    {
Level -2 -        The most important character is the Professor
    }
    {
Level -2 -        Another character is that of Berlin
        {
Level -3 -            Berlin is in charge of the money heist
        }
    }
    {
Level -2 -        Another character is that of Moscow
        {
            Moscow is Denver's dad
        }
    }
    {
Level -2 -        Another character is that of Rio
        {
            Rio is a programmer
            {
                Rio is also a decent hacker
                {
                    Rio is quite happy to be a part of the heist
                }
            }
        }
    }
    {
Level -2 -        Another character is that of Denver
    }
}
 */
public class JavaBracketParser {

	public static void main(String[] args) {
		
		String chars = "{\n" + 
				"    Money Heist Info\n" + 
				"    {\n" + 
				"        The most important character is the Professor\n" + 
				"    }\n" + 
				"    {\n" + 
				"        Another character is that of Berlin\n" + 
				"        {\n" + 
				"            Berlin is in charge of the money heist\n" + 
				"        }\n" + 
				"    }\n" + 
				"    {\n" + 
				"        Another character is that of Moscow\n" + 
				"        {\n" + 
				"            Moscow is Denver's dad\n" + 
				"        }\n" + 
				"    }\n" + 
				"    {\n" + 
				"        Another character is that of Rio\n" + 
				"        {\n" + 
				"            Rio is a programmer\n" + 
				"            {\n" + 
				"                Rio is also a decent hacker\n" + 
				"                {\n" + 
				"                    Rio is quite happy to be a part of the heist\n" + 
				"                }\n" + 
				"            }\n" + 
				"        }\n" + 
				"    }\n" + 
				"    {\n" + 
				"        Another character is that of Denver\n" + 
				"    }\n" + 
				"}";
		System.out.println(" length of char "+chars.length());
		System.out.println("first index of { "+chars.indexOf("{"));
		System.out.println("first index of { "+chars.lastIndexOf("}"));
		
		splitStringTest1(chars);

	}
	
	private static void splitStringTest1(String chars){
		Scanner scanner = new Scanner(chars);
		String tmp ="";
		StringBuilder sb = new StringBuilder();
		Stack<String> stack = new Stack<String>();
		Map<String, List<String> > map = new HashMap<>();
		//BlockingQueue<String> queue = new LinkedBlockingQueue<>();
		while(scanner.hasNext()) {
			String tt = scanner.nextLine();
			System.out.println("NEXT line is "+tt);
			if(tt.trim().equals("{")) {
				System.out.println("Got { pushing to stack");
				stack.push(tt.trim());
			}else if(tt.trim().equals("}")){
				System.out.println("Got } removing from stack");
				stack.pop();
			}else {
				int size = stack.size();
				if(map.containsKey(String.valueOf(size))) {
					List<String> lst = map.get(String.valueOf(size));
					lst.add(tt.trim());
					map.put(String.valueOf(size), lst);
				}else {
					List<String> lst = new ArrayList();
					lst.add(tt.trim());
					map.put(String.valueOf(size), lst);
				}
			}
			System.out.println("queue size "+stack.size());
		}
		
		System.out.println("OUTPUT "+map);
	}
	
}
