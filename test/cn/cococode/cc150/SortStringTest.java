package cn.cococode.cc150;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortStringTest {

	@Test
	public void test() {
		SortString s = new SortString();
		String[] strings = {"ivkfyvng", "gikvvynf","ftytv","ttvyf","tfyvt","vtytf"};
//			{"emmaldzsvjggzfoda","skmjhsm","zjwmkgufsvwrwyvrhk","vyksgrwwjmwrhzfvuk",
//				"wfszrykvjrmuwhkvgw","kwrwuwjvksyvhmrzfg","kom","mko","mko","nezrxmdjgjqexmqz",
//				"gjmqdrzqzjeemxxn","qqxedgjjmrznmxez","xxgmjezerjnqmzdq","vwcmmngdsvzx",
//				"xvmdvwscgnmz","msnvvczxdgwm","izmvzrhltsiubcukc","cslnzuenr","rznulsenc","lnsnucrez",
//				"gkyfvvni","gikvvynf","ivkfyvng","vygfvikn","nwxkeyhnvniquhpapw","wnhyknvanhepwquxip",
//				"rrpujexoukmmrnmpdzcf","ksirghrnjx","ixrhgkrnjs","kup","kpu","kpu","emnetqjwnfwi","qpozvklf",
//				"qpvkolfz","flpkvoqz","zlkpvfoq","zldjqciktnevrkb","vklqjdrktcebizn","ntrqkvebiljczkd","nkktcebjirqvldz",
//				"mytegbucud","gbtcyuemud","gctmuedybu","ahgeomesgcehvk","oamshhecevggek","gmcekevoehsahg",
//				"gvgeacmheeoksh","ma","am","am","wxdyddyrenzsylfwx","syedwdylxrwfyxzdn","dwsddyelxywrxyfnz",
//				"rdrrfuowxukryfmli","qdjzmdobajs","ymysuotfxpboc","awzccscrkozbhygrkvv","ovrgybhswrczzkcacvk",
//				"zcrwkyhrzkgacvsocbv","vzwgzosrkvkcrcybahc","ftytv","ttvyf","tfyvt","vtytf","pggunxuyduy","qijygauutkt",
//				"aytqutkugji","itjutqugaky","nfoenumvnmannkkhmueo","ounmkhknefvemnmannou",
//				"eonmenfkhmuaonnnumvk","mvnouemekonfamnnnhku","a"};
		System.out.println(s.getStringCount("vzwgzosrkvkcrcybahc"));
		assertEquals(s.getStringCount("ftytv"), s.getStringCount("ttvyf"));
		System.out.println(s.sortStrings(strings, 74));
	}

}
