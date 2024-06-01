package com.example.custom;

public interface CustomRepository {
	void depositUpdate(int id, int amount);
	void withdwarlUpdate(int id, int amount);
	void moneyTransfer(int id,  int amount, int receiverId);
}
