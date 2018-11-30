
public class Test {
  public static void main(String[] args){
	  Person taro=new Person();
	  taro.name="山田太郎";
	  taro.age=20;
	  taro.phoneNumber="84686";
	  taro.address="東京";

	  System.out.println(taro.name);
	  System.out.println(taro.age);
	  System.out.println(taro.phoneNumber);
	  System.out.println(taro.address);
	  taro.talk();
	  taro.walk();
	  taro.run();


	  Person jiro=new Person();
      jiro.name="木村次郎";
	  jiro.age=18;
	  jiro.phoneNumber="42078";
	  jiro.address="アメリカ";

	  System.out.println(jiro.name);
	  System.out.println(jiro.age);
	  System.out.println(jiro.phoneNumber);
	  System.out.println(jiro.address);
	  jiro.talk();
	  jiro.walk();
	  jiro.run();



	  Person hanako=new Person();
	hanako.name="鈴木花子";
	hanako.age=16;
hanako.phoneNumber="912749";
	hanako.address="大阪";

	  System.out.println(hanako.name);
	  System.out.println(hanako.age);
	  System.out.println(hanako.phoneNumber);
	  System.out.println(hanako.address);
	  hanako.talk();
	  hanako.walk();
	  hanako.run();



	  Person jun=new Person();
      jun.name="麻生隼希";
	  jun.age=23;
	  jun.phoneNumber="1028473";
	  jun.address="富山";

	  System.out.println(jun.name);
	  System.out.println(jun.age);
	  System.out.println(jun.phoneNumber);
	  System.out.println(jun.address);
	  jun.talk();
	  jun.walk();
	  jun.run();



	  Robot aibo=new Robot();
	  aibo.name="相棒";
	  System.out.println(aibo.name);
	  aibo.talk();
	  aibo.walk();
	  aibo.run();


	  Robot asim=new Robot();
	  asim.name="アシモ";
	  System.out.println(asim.name);
	  asim.talk();
	  asim.walk();
	  asim.run();


	  Robot pepper=new Robot();
	pepper.name="ペッパー";
	 System.out.println(pepper.name);
	pepper.talk();
	pepper.walk();
	pepper.run();

  }
}
