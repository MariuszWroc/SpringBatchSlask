/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.springbatchforslask.batch;

import org.springframework.batch.item.ItemProcessor;
import pl.mariuszczarny.springbatchforslask.model.Arrange;

/**
 *
 * @author mczarny
 */
public class ArrangeProcessor implements ItemProcessor<Arrange, Arrange>{
	
	@Override
	public Arrange process(Arrange result) throws Exception {
		System.out.println("Processing result :"+result);
		
		return result;
	}
}
