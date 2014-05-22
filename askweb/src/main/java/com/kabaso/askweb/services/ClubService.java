/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kabaso.askweb.services;

import com.kabaso.askweb.domain.Club;

/**
 *
 * @author hashcode
 */
public interface ClubService extends Services<Club, Long>{
    public Club getClubByName(String name);
    public int getNumberOfClubs();
    
}
