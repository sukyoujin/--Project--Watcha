package model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WatchaDTO {
	   private String name;
	   private String star;
//	   private String urlImg;

	   @Override
	   public String toString() {
	      StringBuilder builder = new StringBuilder();
//	      builder.append("{\"Name\": " + name);   
//	      builder.append(", ");   
//	      builder.append("\"Rank\": " + star + "}");  
	      builder.append("[\'" + name + "\'");   
	      builder.append(", ");   
	      builder.append(star + "]");     

//	      builder.append("\'" + star + "\'");     
//	      builder.append(", ");   
//	      builder.append("\'" + urlImg + "\']");      

	      return builder.toString();
	   }
	}