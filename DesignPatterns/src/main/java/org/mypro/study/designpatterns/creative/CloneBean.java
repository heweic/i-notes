package org.mypro.study.designpatterns.creative;

/**
 * 原型模式(克隆模式)
 * 
 * <pre>
浅克隆：创建一个新对象，新对象的属性和原来对象完全相同，对于非基本类型属性，仍指向原有属性所指向的对象的内存地址。
深克隆：创建一个新对象，属性中引用的其他对象也会被克隆，不再指向原有对象地址。
适用场景：
	对象之间相同或相似，即只是个别的几个属性不同的时候。
	创建对象成本较大，例如初始化时间长，占用CPU太多，或者占用网络资源太多等，需要优化资源。
	创建一个对象需要繁琐的数据准备或访问权限等，需要提高性能或者提高安全性。
	系统中大量使用该类对象，且各个调用者都需要给它的属性重新赋值。
 * </pre>
 * 
 * @author hew
 * @time 2021年1月19日 上午10:50:40
 */
public class CloneBean implements Cloneable {

	private String id;
	private String name;
	private int age;

	public CloneBean() {
	}

	public CloneBean(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	/**
	 * 浅克隆的 clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return (CloneBean) super.clone();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static void main(String[] args) {
		try {
			CloneBean bean = new CloneBean("001", "张三", 18);
			System.out.println("ID:" + bean.getId() + " " + bean.getName() + " 年龄:" + bean.getAge());

			CloneBean bean2 = (CloneBean) bean.clone();
			bean2.setId("002");
			bean2.setName("李四");
			System.out.println("ID:" + bean2.getId() + " " + bean2.getName() + " 年龄:" + bean2.getAge());
			System.out.println(bean == bean2);
		} catch (Exception e) {

		}
	}

}
