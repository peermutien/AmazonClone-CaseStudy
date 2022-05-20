package com.capg.model;

import java.util.ArrayList;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CartDetails {

		private UUID userId;
		private ArrayList<Product> list;
		public UUID getUserId() {
			return userId;
		}
		public void setUserId(UUID userId) {
			this.userId = userId;
		}
		public ArrayList<Product> getList() {
		
			return list;
		}
		public void setList(ArrayList<Product> list) {
			this.list = list;
		}
}
