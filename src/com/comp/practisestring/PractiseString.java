package com.comp.practisestring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class PractiseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		
		System.out.println("mod/remainder::"+5%10);
		System.out.println("div::"+45/10);
		int[] s=new int[] {1, 2, 3, 4, 4};
		String[] words =new String[] {"mass","as","hero","superhero"};
		PractiseString ps=new PractiseString();
		String  sent = "is2 sentence4 This1 a3";
		String sort=ps.sortSentence(sent);
		System.out.println("Sorted Sentence ::"+sort);
		
		String address = "1.1.1.1";
		String ipAddress=ps.defangIPaddr(address);
		System.out.println("ipAddress"+ipAddress);
		
		boolean isIsomorphic=ps.isIsomorphic("paper", "title");
		System.out.println("isIsomorphic"+isIsomorphic);
		List<String> results=ps.stringMatching(words);
		for(String str:results) {
			System.out.println("["+ str +" ]");
		}
		boolean isSorted=ps.isSorted(s);
		System.out.println("ascending"+ isSorted);
		String input=" geeks for geeks";
		 char[] temparray = input.toCharArray();
		 StringBuilder sb=new StringBuilder();
		 for(int i=0;i<input.length();i++)
			 sb.append(temparray[i]);
		 System.out.println("Reversed String"+sb.reverse());
		 reverseStringRecursive(input);
		 
		 //reverseStringBestCase("Lampet");
		 boolean isPalin=isPalindrome(",; W;:GlG:;l ;,");
		 System.out.println("isPalindrome::"+isPalin);
		 reverseStringCollections(input);
		 int[] indices = new int[] {4,0,2,6,7,3,1,5};
		 System.out.println(restoreString("aaiougrt", indices));
	}

	public List<String> stringMatching(String[] words) {
		List<String> resultList = new ArrayList<String>();
		//Arrays.sort
		for (int i = 0; i < words.length; i++) {
			for (int j = i+1; j < words.length; j++) {
				if (words[j].contains(words[i]) && !resultList.contains(words[i])) {
					resultList.add(words[i]);
				}else if(words[i].contains(words[j]) && !resultList.contains(words[j])) {
					resultList.add(words[j]);
				}
			}
		}
		return resultList;
		
		

	}
	
	    public String sortSentence(String s) {
	    	StringBuilder result=new StringBuilder();
	    	TreeMap<Character,String> map=new TreeMap<Character, String>();
        	
	    	String[] words=s.split("\\ ");
	    	for(String word:words) {
	    		String str=word.substring(0, word.length()-1);
	    	    char pos=word.charAt(word.length()-1);
	    		map.put(pos, str);
	    	}
	    	int mapSize=map.size();
	    	int count=1;
	        for(Map.Entry<Character, String> entry: map.entrySet()) {
	        	
	           
	        	result.append(entry.getValue());
	        	if(count<mapSize)
	        	result.append(" ");
	        	count++;
	        }
	  
	        return result.toString();
	    }

	public boolean isIsomorphic(String s, String t) {
		int len_s = s.length() - 1;
		int len_t = t.length() - 1;
		HashMap<Character, Character> isoMap = new HashMap<Character, Character>();

		StringBuilder sb = new StringBuilder();
		String valStr = "";
		if (len_s != len_t) {
			return false;
		}
		for (int i = 0; i <= len_s; i++) {
			if (!isoMap.containsKey(s.charAt(i))) {
				if (isoMap.containsValue(t.charAt(i)))
					return false;
				isoMap.put(s.charAt(i), t.charAt(i));
			}
		}

		char[] sArr = s.toCharArray();
		for (int i = 0; i <= len_s; i++) {
		    sArr[i] = isoMap.get(sArr[i]);
		}
		
		System.out.println(">>> " + sArr.toString());

		if (sArr.toString().equals(t))
			return true;
		return false;
	}
	 
	 public boolean isIsomorphic2(String s, String t) {
	
	     
		 if(s.length() != t.length()) return false;
		 
		 Set<Character> tSet = new HashSet<Character>();
		 Map<Character, Character> isoMap = new HashMap<Character, Character>();
		 
		 for(int i = 0; i < s.length(); i++) {
		
		 
		 
		 return false;
		 
	 }
	 

	private static void reverseStringCollections(String input) {
		// TODO Auto-generated method stub
		char[] temparray = input.toCharArray();
		List tempList =new ArrayList<String>();
		
		for (char c : temparray)
			tempList.add(c);
		Collections.reverse(tempList);
		tempList        
        .forEach( 
            s -> { 
                System.out.print(s); 
            }); 
 
	
		
	}

	private static void reverseStringBestCase(String input) {
		char[] temparray = input.toCharArray();
		int first=0;
		int last=temparray.length-1;
		int mid=(first+last)/2;
		for(char c: temparray) {
			char temp=temparray[last];
			temparray[first]=temp;
			temparray[last]=c;
			first++;
			last--;
			if(first==mid+1) {
				break;
			}
			
		}
		
		for (char ci: temparray) {
			System.out.println("reversed string: "+ ci);
		}
		// TODO Auto-generated method stub
		
	}

	private static void reverseStringRecursive(String input) {
		// TODO Auto-generated method stub
		
	}
	
	
	 public int firstUniqChar(String s) {
	
	        char[] c= s.toCharArray();
	        Character[] newArray = new Character[c.length];

	        Map<Character, MyPair<Integer,Integer>> map =new LinkedHashMap<Character, MyPair<Integer,Integer>>();
	        
	        for(int i=0;i<=newArray.length-1;i++) {
	        	if(!map.containsKey(newArray[i])) {
	        		map.put(newArray[i], new MyPair<Integer, Integer>(i, 1));
	        	}
	        	else {
	        		MyPair<Integer, Integer> value = map.get(newArray[i]);
	        		value.setCount(value.getCount()+1);
	        	}
	        }
			int result = -1;
			for (Entry<Character, MyPair<Integer, Integer>> entry:map.entrySet()) {
				if(entry.getValue().getCount() ==1) {
					result =  entry.getValue().getIndex();
				}
			}
			return result;

	    }
	 
	    public int reverse(int x) {
	    	
		return x;
	        
	    }
	    
	    public boolean isAnagram(String s, String t) {
	        StringBuilder sb=new StringBuilder(t);
	        char[] first=s.toCharArray();
	        for(char c: first) {
	        	int index=sb.indexOf(""+c);
	        	if(index!=-1) {
	        		sb.deleteCharAt(index);
	        	}
	        	else {
	        		return false;
	        	}
	        }
			return sb.length()==0 ? true :false;
	    }
	    
	    public int[] intersect(int[] nums1, int[] nums2) {
	        int n1_len=nums1.length-1;
	        int n2_len=nums2.length-1;
	        int i =0; int j=0 ;int k=0; 
	        //int[] intersectArray=new int[n1_len+n2_len+1];
	        ArrayList<Integer> intersectArray=new ArrayList<Integer>();
	        while (i<=n1_len && j <= n2_len){
	            if(nums1[i]<nums2[j]){
	                i++;
	               
	            }
	            else if(nums2[j] > nums1[i]){
	                j++;
	            }
	            else{
	                //intersectArray[k]=nums2[j];
	                intersectArray.add(nums2[j]);
	                j++;
	                i++;
	               // k++;
	            }
	        }
	        return intersectArray.stream().mapToInt(a -> a).toArray();
	    }
	    public char findTheDifference(String s, String t) {
	    	
	       char[] sArrray= s.toCharArray();
	       char[] tArray=t.toCharArray();
	       Arrays.sort(sArrray);
	       Arrays.sort(tArray);
	       return tArray[tArray.length-1];
	     }
	    
	    public boolean isSorted(int[] array) {
	        for (int i = 0; i < array.length - 1; i++) {
	            if (array[i] > array[i + 1])
	                return false;
	        }
	        return true;
	    }
	    
		public String addStrings(String num1, String num2) {

			int len_n1 = num1.length() - 1;
			int len_n2 = num2.length() - 1;
			int sumArrayLen = len_n1 > len_n2 ? len_n1 : len_n2;
			StringBuilder sumStr = new StringBuilder();
			int k = 0;
			int carry = 0;
			while (len_n1 >= 0 || len_n2 >= 0) {
				int sum = carry;
				if (len_n1 >= 0)
					sum += Integer.parseInt(String.valueOf(num1.charAt(len_n1)));
				if (len_n2 >= 0)
					sum += Integer.parseInt(String.valueOf(num2.charAt(len_n2)));
				sumStr =  new StringBuilder(sum % 10).append(sumStr);
				carry = sum / 10;
				len_n1--;
				len_n2--;
			}

			if (carry > 0) {
				sumStr = new StringBuilder(carry).append(sumStr);
			}

			return sumStr.toString();
		}
	
	    public static boolean isPalindrome(String s) {
	    	
	    	String newStr =   s.replaceAll(
	    	          "[^a-zA-Z0-9]", "");
	    	System.out.println("new str ::"+newStr);
	    	String aStr=newStr.toLowerCase();
	    	System.out.println("lowercase ::"+aStr);
	    	if(aStr.length()==0 || aStr.length()==1){
	            return true;
	        }
	    	char[] carray=aStr.toCharArray();
	    	int left=0;
	    	int right=aStr.length()-1;
	    	boolean isPalin = false;
	    	while(left<right) {
	    		
				if(carray[left]==carray[right]) {
	    			isPalin=true;
	    		}else {
	    			isPalin=false;
	    			break;
	    		}
	    		left++;
	    		right--;
	    	}
			return isPalin;
	        
	    }
	    
	    public String defangIPaddr(String address) {
	    	StringBuilder result=new StringBuilder();
	        String[] str= address.split("\\.");
	        int count=1;
	        for(int i=0; i< str.length; i++ ) {
	        	result.append(str[i]);
	        	if(i!=str.length-1) {
                result.append("[.]");
	        	}
	        	
	        }
	        return result.toString();
	    }
	    public static String restoreString(String s, int[] indices) {
//	    s.charAt(0)
	        /*HashMap<Integer, Character> map=new HashMap<Integer, Character>();
	        char[] ch=s.toCharArray();
	        char[] result=new char[ch.length];
	        for(int i=0; i< indices.length; i++){
	            map.put(indices[i], s.charAt(i));
	        }
	        
	        for(int j=0; j< ch.length; j++){
	            
	            result[j] = map.get(j);
	        }
	        return new String(result);
	        
	        char[] result=new char[s.length()];
	        for(int i = 0; i < s.length(); i++) {
	            result[i] = s.charAt(indices[i]);
	        }
	        
	        return new String(result);*/
	        char[] ch=s.toCharArray();
	        
	        int   i = 0;
	        while (i < indices.length) {
	            if(i != indices[i]) {
	                //swap
	                char charAtI = ch[i];
	                int intAtI = indices[i];
	                
	                ch[i] = ch[indices[i]];
	                ch[indices[i]] = charAtI;

	                indices[i] = indices[intAtI];
	                indices[intAtI] = intAtI; 
	                               
	            }
	            else {
	                i++;
	            }
	        }
	        return new String(ch);
	    }
}
