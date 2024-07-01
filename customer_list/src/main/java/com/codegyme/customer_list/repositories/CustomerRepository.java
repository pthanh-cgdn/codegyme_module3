package com.codegyme.customer_list.repositories;

import com.codegyme.customer_list.models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private static List<Customer> customers = new ArrayList<>();
    static{
        customers.add( new Customer(1,"Michael Jackson","1960-10-10","USA","https://image.winudf.com/v2/image1/Y29tLmFwcC5sb3ZlLmphY2tzb24ubWljaGFlbC5taWNoYWVsX2phY2tvbl9zY3JlZW5fNl8xNTg2NTQ1NjU0XzAzNw/screen-2.jpg?fakeurl=1&type=.jpg"));
        customers.add( new Customer(2,"Taylor Swift","1989-05-06","USA","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpSmMYpqOzKZmo77Pat87SxfmH5NEteWPYcw&s"));
        customers.add( new Customer(3,"Lisa","1995-12-26","Korea","https://i.pinimg.com/originals/87/e3/68/87e3680db94fa0baa744017596863653.jpg"));
    }

    public List<Customer> getAll() {
        return customers;
    }
}
