package reboot.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class PermissionController {
	
	
	/**
	 * This method checks the users authentication level
	 * @return true or false
	 */
	
	public boolean hasUserRole() {
		// this checks to see if a user has a user role
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean hasUserRole = authentication.getAuthorities().stream()
		         .anyMatch(r -> r.getAuthority().equals("ROLE_USER"));
		return hasUserRole;
	}
	
	/**
	 * This method returns the users authentication level
	 * @return true or false
	 * 
	 */
	
	public boolean hasAdminRole() {
		// this checks to see if a user has a admin role.
		Authentication authentication2 = SecurityContextHolder.getContext().getAuthentication();
		boolean hasAdminRole = authentication2.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
		return hasAdminRole;
	}

}
