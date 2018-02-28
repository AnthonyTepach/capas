/*
 * Copyright (C) 2018 inspector
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.tepach.datos;

import java.util.HashMap;

/**
 *
 * @author inspector
 */
public class GetSet {
    private HashMap<String,String> data= new HashMap<>();

    /**
     * @return the data
     */
    public HashMap<String,String> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(HashMap<String,String> data) {
        this.data = data;
    }
    
}
