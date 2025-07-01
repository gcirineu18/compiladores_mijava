package com.example.mijava.visitor.IRTree;


import com.example.mijava.irtree.ExpAbstract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor; 

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Exp {

	public ExpAbstract exp;

	public ExpAbstract unEx() {
		return exp;
	}
}