package com.kevinhuang.study;
public class Number2RMB
{
	
	//主程序入口，先创建对象，然后执行readInChinese方法
	public static void main(String[ ] args)
	{
	  Number2RMB n = new Number2RMB();
	  n.readInChinese(n.input);
	}
	
	
	//定义一个输入的double数据
	public double input;


	//定义中文数字数组
	String[] chinese = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};


	//定义单位数组（单位按照位数从小到大来排序）
	String[ ] unit = {"分","角","圆","拾","佰","仟","萬","拾","佰","仟","亿","拾","佰","仟"};


	//定义一个构造器，初始化输入的double数据；
	public Number2RMB()
	{
	  input = 23;
	}

	  //编写转化方法，思路，将该数乘以100，再除以10的i次幂，再取整，如果结果不为零，则加上结果和单位；
	public void readInChinese(double input)
	{

	  //此处a不能用int，会造成数据溢出，所用要用long，将double数乘以100，等到一个long数

	  long a = (long)(input*100);

	  int b;
	  int count = 0;//用于记录当前位的上一位是否为0，默认亿亿位为0
	  for (int i=13; i>=0; i--)
	  {
	    b = (int)(a/Math.pow(10.0, i));//b=a/10的b所在位数减1次幂
	    if (b != 0)
	    {
	      a = (long)(a-b*Math.pow(10.0, i));//b不为0时，a=a去掉最高位数，为下一次转换做准备
	      System.out.print(chinese[b]+unit[i%14]);//输出数字和单位
	    }
	    else if (i%4 == 2 && i/2==1)//若b=0，则判断此位是否要输出圆
	    {
	      System.out.print(unit[i%14]);
	      count = b;
	    }
	    else if (i%4 == 2)//判断是否要输出亿或者萬
	    {
	      System.out.print(unit[i%14]+chinese[b]);
	    }
	    else if (count !=0)//判断是否要输出零
	    {
	      System.out.print(chinese[b]);//当b=0时，若count!=0，则输出chinese[0]，即零
	      count = b;
	    }
	    else
	    {
	       //以上条件都不满足时，不打印
	      count = b;
	    }
	  }
	}

}
