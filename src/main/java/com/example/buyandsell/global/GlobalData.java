package com.example.buyandsell.global;

import java.util.ArrayList;
import java.util.List;

import com.example.buyandsell.model.Product;


public class GlobalData {
		public static List<Product> cart;
		static {
			cart = new ArrayList<Product>();
		}
}
