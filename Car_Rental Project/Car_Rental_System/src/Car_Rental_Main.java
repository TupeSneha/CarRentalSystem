package Car_System_Package
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Car
{
	private String carId;
	
	private String model;
	 
	private String brand;
	
	private double basePricePerDay;
	
	private boolean isAvailable;
	
	public Car(String carId,String model, String brand,double basePricePerDay) //constructor
	{
	 this.carId = carId;
	 this.model = model;
	 this.brand = brand;
	 this.basePricePerDay = basePricePerDay;
     this.isAvailable = true;
	}
	
	public String getcarId() //getter method
	{
		return carId;
		
	}
	public String getmodel()
	{
		return model;
	}
	public String getbrand()
	{
		return brand;
	}
	
	public double calculatePrice(int rentalDays) 
	{
		return basePricePerDay = rentalDays;
	}
	
	
	public Boolean isAvailable()
	{
		return isAvailable;
	}
	
	public void rent()
	{
		isAvailable= false;
	}
	public void returnCar()
	{
		isAvailable=true;
	}
	
}
	

class Customer
{
   //public String customersName;
	private String customerId;
	
	private String name;
	
	public Customer(String customerId, String name) //constructor
	{
		this.customerId = customerId;
		this.name = name;
	}
		public String getCustomerId()
		{
			return customerId;
		}
		public String getname()
		{
			return name;
	}
	
}

class Rental //combination of car and customer class
{
	private  Car car;
	private Customer customer;
	private  int days;
	
	public Rental(Car car, Customer customer, int days) //constructor
	{
		this.car = car;
		this.customer = customer;
		this.days = days;
	}
	
	public Car getCar()   //getter method
	{
		return car;
	}
	public Customer getcustomer() 
	{
		return customer;
	}
	public int getDays()
	{
		return days;
	}
	
}

class CarRentalSystem
{
	int customerId;
	//String customersName;
	private static final Car[] Car = null;
	private List<Car> cars;
	private List<Customer> customers;
	private List<Rental> rentals;   //to store customer and car details in rental
	private Customer newCustomer;
	
	public CarRentalSystem()       //constructor
	{
		cars = new ArrayList<>();     // use to input data
		customers = new ArrayList<>();
		rentals = new ArrayList<>();
	}
		public void addCar(Car car)
		{
			cars.add(car);
		}
		
		public void addCustomer(Customer customer)
		{
			customers.add(customer);
		}
		
		public void rentCar(Car car,Customer customer,int days)
		{
			if(car.isAvailable())
					{
				      car.rent();
				      rentals.add(new Rental(car,customer,days));
					}
			else {
				System.out.printf("Car is not available for rent.");
			}
		}
		
		public void returnCar(Car car)
		{
			car.returnCar();
			
			Rental rentalToRemove = null;
			for (Rental rental:rentals)
			{
				if(rental.getCar()== car)
				{
					rentalToRemove = rental;
					break;
				}
			}
			if (rentalToRemove != null)
			{
				rentals.remove(rentalToRemove);
		
			}
			else {
				System.out.println("Car was not rented.");
			}	
		}
		public void menu()
		{
		  Scanner scanner=new Scanner(System.in);
		   while(true)
		   {
			   System.out.println("***** Car Rental System *****");
			   System.out.println("1. Rent a Car");
			   System.out.println("2. return a Car");
			   System.out.println("3. Exit");
			   System.out.println("Enter your choice:");
			   
			   int choice = scanner.nextInt();
			   scanner.nextLine();
			   
			   if(choice==1)
			   {
				   System.out.println("\n Enter a Car \n");
				   System.out.println("\n Enter your name \n");
				   String customerName = scanner.nextLine();
				   
				   System.out.println("\n Available Cars:");
				   for(Car car:Car)
				   {
					   if(car.isAvailable()) {
						   System.out.println("car.getId().....car.getBrand().....car.getModel()");
						   
					   }
				   }
				   System.out.print("\nEnter car ID you want to rent:");
				   String carId =scanner.nextLine();
				   
				   System.out.print("Enter the number of days for rental:");
				   int rentalDays = scanner.nextInt();
				   scanner.nextLine();
				   
				   Customer newcustomer= new Customer("CUS" +(customers.size()+1),customerName);
			       addCustomer(newCustomer);
			       
			       Car selectedCar = null;
			       for(Car car:cars)
			       {
			    	   if(car.getcarId().equals(carId) && car.isAvailable());
			    	   {
			    		   selectedCar=car;
			    		   break;
			    	   }
			       }
			       if (selectedCar!=null)
			       {
			    	   double totalPrice= selectedCar.calculatePrice(rentalDays);
			    	   System.out.println("\n== Rental Information ==\n");
			    	   System.out.println("Customer ID:"+ newCustomer.getCustomerId());
			    	   System.out.println("Customer Name:"+ newCustomer.getname());
			    	   System.out.println("Car:"+ selectedCar.getbrand()+ " "+selectedCar.getmodel());
			    	   System.out.println("Rental Days:"+rentalDays);
			    	   System.out.printf("Total price:",totalPrice);
			    	   
			    	   System.out.println("\n Confirm rental(Y/N):");
			    	   String confirm=scanner.nextLine();
			    	   
			    	   if(confirm.equalsIgnoreCase( "Y"))
			    	   {
			    		   rentCar(selectedCar, newCustomer, rentalDays);
			    		   System.out.println("\ncar rented successfully.");
			    	   }
			    	   else
			    	   {
			    		   System.out.println("\n Rental canceled.");

			    	   }
			       }
			    	   else {
			    		   System.out.println("Invalid car selection or car not available for rent.");
			    	   }  
			         }
			       else if(choice ==2) 
			       {
			    	   System.out.println("\n **Return a Car **\n");
			    	   System.out.println("Enter the car ID you want to return:");
			    	   String carId= scanner.nextLine();
			    	   
			    	   Car carToReturn = null;
			    	   for(Car car:cars)
			    	   {
			    		 if(car.getcarId().equals(carId) && car.isAvailable()) 
			    		 {
			    		    carToReturn = car;
			    		    break;
			    			 
			    		 }
			    	   }
			    	   if(carToReturn!=null)
			    	   {
			    		   Customer customer = null;
			    		   for(Rental rental:rentals)
			    		   {
			    			   if(rental.getCar()==carToReturn)
			    			   {
			    				   customer=rental.getcustomer();
			    				   break;
			    			   }
			    		   }
			    		   
			    		   if (customer!=null)
			    		   {
			    			   returnCar(carToReturn);
			    			   System.out.println("Car returned successfully by"+ customer.getname());
			    		   }
			    		   else
			    		   {
			    			   System.out.println("Car was not rented or rental information is missing:");
			    		   }
			    	   }
			    	   else{
			    		   System.out.println("Please enter a valid option:");
			    		   
			    	   } 
			       }
			       System.out.println("\nThank you for using Car Rental System");
			   }  
		}
}
		   class Car_Rental_Main
		   {
			 public static void main(String[]args)
			 {
				 CarRentalSystem rentalSystem = new  CarRentalSystem();
				 Car car1=new Car("C001","Honda","Accord",80.0);
				 Car car2=new Car("C002", "Toyota", "Camry",1500.0);
				 Car car3=new Car("C003","Mahindra","Thar",60.0);
				 rentalSystem.addCar(car1);
				 rentalSystem.addCar(car2);
				 rentalSystem.addCar(car3);
				 
				 rentalSystem.menu();
				 	 
			 }
		   }
		

