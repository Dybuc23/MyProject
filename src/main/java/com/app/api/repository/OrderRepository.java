package com.app.api.repository;

import com.app.api.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    @Query(value="select det.order_id , det.product_id , prod.name\n" +
            "from order_details det\n" +
            "inner join t_product prod on det.product_id= prod.product_id\n" +
            "inner join t_order ord on det.order_id=ord.order_id;",nativeQuery = true)
    public abstract Collection<Object[]> findAll_withProducts();
    @Query(value="select ord.order_id,ord.paydocument,cl.businessname,cl.office,cl.address,paycond.payment_id,paycond.name\n" +
            "from t_order ord\n" +
            "inner join t_client cl on ord.client_id= cl.client_id\n" +
            "inner join t_businesskind bk on bk.business_id=cl.business_id\n" +
            "inner join t_payment_condition paycond on paycond.type_id=bk.business_id;",nativeQuery = true)
    public abstract Collection<Object[]> findAll_withPaymentCondition();
}
