package com.hea.eztalk.domain;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Hea {
    
    static long TEN_DAYS = (1000 * 60 * 60 * 24 * 10);

	String name;
	Level level; 
	boolean active;
	Date recentActivityDate;

    // Long account;
    Long currentBalance;

	@Id @GeneratedValue
	Long id;


	public boolean check잠수(){
		Date today = new Date();
		if(today.before( new Date(getRecentActivityDate().getTime() + TEN_DAYS) ) ){
			return false;
		}else
			return true;
	}



    public boolean checkAccountStatus(){
		currentBalance = getCurrentBalance();
		System.out.println("[LOG] currentBalance ::: " + currentBalance);

		if( currentBalance > 0 ){
			return true;
		}else
			return false;
	}



	//////// setters / getters ////////

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
	}



	public Date getRecentActivityDate() {
		return recentActivityDate;
	}



	public void setRecentActivityDate(Date recentActivityDate) {
		this.recentActivityDate = recentActivityDate;
	}



	public Level getLevel() {
		return level;
	}



	public void setLevel(Level level) {
		this.level = level;
	}



    public Long getCurrentBalance() {
        return currentBalance;
    }


    public void setCurrentBalance(long l) {
        this.currentBalance = l;
    }


}
