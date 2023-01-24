package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Stock;

public interface StockRepo extends JpaRepository<Stock, Integer> {

	@Query("select new Stock(s.sid, s.p, sum((case when s.flag='purchase' then s.qty else 0 end)+(case when s.flag='open' then s.qty else 0 end)-(case when s.flag='sell' then s.qty else 0 end)) as cqty ) from Stock s group by s.p")
	public List<Stock> getcurrentStock();
	
}
