package com.app.api.util;

import java.util.ArrayList;
import java.util.Collection;

import com.app.api.entity.*;
import com.app.api.mapper.*;

public class UtilMapper {

	public static Collection<UserMapper> toUser(Collection<Users> users)
	{
		Collection<UserMapper> mapper=new ArrayList<>();
		
		for(Users user:users) 
		{
			UserMapper userMapper=new UserMapper(user);
			mapper.add(userMapper);
		}
		
		return mapper;
	}
	public static Collection<BusinessMapper> toBusiness(Collection<BusinessKind> business)
	{
		Collection<BusinessMapper> mapper=new ArrayList<>();

		for(BusinessKind businessKind:business)
		{
			BusinessMapper businessMapper=new BusinessMapper(businessKind);
			mapper.add(businessMapper);
		}

		return mapper;
	}
	public static Collection<ClientMapper> toClient(Collection<Client> clients)
	{
		Collection<ClientMapper> mapper=new ArrayList<>();

		for(Client client:clients)
		{
			ClientMapper clientMapper=new ClientMapper(client);
			mapper.add(clientMapper);
		}

		return mapper;
	}
	public static Collection<OrderMapper> toOrder(Collection<Order> orders)
	{
		Collection<OrderMapper> mapper=new ArrayList<>();

		for(Order order:orders)
		{
			OrderMapper orderMapper=new OrderMapper(order);
			mapper.add(orderMapper);
		}

		return mapper;
	}
	public static Collection<ProductMapper> toProduct(Collection<Product> products)
	{
		Collection<ProductMapper> mapper=new ArrayList<>();

		for(Product product:products)
		{
			ProductMapper productMapper=new ProductMapper(product);
			mapper.add(productMapper);
		}

		return mapper;
	}
	public static Collection<PymtCondMapper> toPayment(Collection<PaymentCondition> paymentCond)
	{
		Collection<PymtCondMapper> mapper=new ArrayList<>();

		for(PaymentCondition pymt:paymentCond)
		{
			PymtCondMapper pymtCondMapper=new PymtCondMapper(pymt);
			mapper.add(pymtCondMapper);
		}

		return mapper;
	}


}
