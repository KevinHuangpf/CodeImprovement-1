package com.kevinhuang.study;
public class Number2RMB
{
//����һ�������double����
public double input;


//����������������
String[] chinese = {"��","Ҽ","��","��","��","��","½","��","��","��"};


//���嵥λ���飨��λ����λ����С����������
String[ ] unit = {"��","��","Բ","ʰ","��","Ǫ","�f","ʰ","��","Ǫ","��","ʰ","��","Ǫ"};


//����һ������������ʼ�������double���ݣ�
public Number2RMB()
{
  input = 23;
}


  //��дת��������˼·������������100���ٳ���10��i���ݣ���ȡ������������Ϊ�㣬����Ͻ���͵�λ��
public void readInChinese(double input)
{

  //�˴�a������int��������������������Ҫ��long����double������100���ȵ�һ��long��

  long a = (long)(input*100);

  int b;
  int count = 0;//���ڼ�¼��ǰλ����һλ�Ƿ�Ϊ0��Ĭ������λΪ0
  for (int i=13; i>=0; i--)
  {
    b = (int)(a/Math.pow(10.0, i));//b=a/10��b����λ����1����
    if (b != 0)
    {
      a = (long)(a-b*Math.pow(10.0, i));//b��Ϊ0ʱ��a=aȥ�����λ����Ϊ��һ��ת����׼��
      System.out.print(chinese[b]+unit[i%14]);//������ֺ͵�λ
    }
    else if (i%4 == 2 && i/2==1)//��b=0�����жϴ�λ�Ƿ�Ҫ���Բ
    {
      System.out.print(unit[i%14]);
      count = b;
    }
    else if (i%4 == 2)//�ж��Ƿ�Ҫ����ڻ����f
    {
      System.out.print(unit[i%14]+chinese[b]);
    }
    else if (count !=0)//�ж��Ƿ�Ҫ�����
    {
      System.out.print(chinese[b]);//��b=0ʱ����count!=0�������chinese[0]������
      count = b;
    }
    else
    {
       //����������������ʱ������ӡ
      count = b;
    }
  }
}

//��������ڣ��ȴ�������Ȼ��ִ��readInChinese����
public static void main(String[ ] args)
{
  Number2RMB n = new Number2RMB();
  n.readInChinese(n.input);
}
}