package com.snow.example.module.b.client;

import com.snow.example.module.a.accessible.Accessible;
import com.snow.example.module.a.internal.Internal;
import com.snow.example.module.a.internalfriends.InternalFriends;

public class TestAccessRules {
	public static void main(String[] args) {
		new Accessible();
		
		new Internal();
		
		new InternalFriends();
	}
}
