/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.springbatchforslask.batch;

import org.springframework.batch.item.ItemProcessor;
import pl.mariuszczarny.springbatchforslask.model.Coach;

/**
 *
 * @author mczarny
 */
public class CoachProcessor implements ItemProcessor<Coach, Coach>{
	
	@Override
	public Coach process(Coach result) throws Exception {
		System.out.println("Processing result :"+result);
		
		return result;
	}
    
}
