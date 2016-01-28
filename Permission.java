package common.objects;

import lombok.CommonObj;
import lombok.IDField;
import common.objects.Activity;
import common.objects.Role;
import common.objects.CommonObject;

/**
 * This class contains an individual Permission, used with {@link Role} and {@link Activity} objects.
 * @author Brian A Lantz - V065512
 *
 */
@CommonObj
public class Permission extends CommonObject
{
	/**
	 * The first possible error message that can be sent by the {@link #validate()} method.
	 * This one is sent if the {@link #name} is null.
	 */
	public static final String VALIDATE_FAILURE1 = "Trying to send an null Name";
	/**
	 * The second possible error message that can be sent by the {@link #validate()} method.
	 * This one is sent if the {@link #name} is an empty String.
	 */
	public static final String VALIDATE_FAILURE2 = "Trying to send an empty Name";

	/**
	 * The name of this permission.
	 */
	@IDField
	String name = null;
	String group = null;
	
	public Permission ()
	{
		this ("");
	}
	
	/**
	 * The complete constructor.
	 * @param name The name of this Permission.
	 */
	public Permission (String name)
	{
		this (name, "");
	}
	
	/**
	 * Gets the name of this Permission.
	 * @return Returns the name of this Permission, or "" if null.
	 */
	public String getName()
	{
		if (name == null)
			return "";
		return name;
	}

	/**
	 * Gets the group of this Permission.
	 * @return Returns the group of this Permission, or "" if null.
	 */
	public String getGroup()
	{
		if (group == null)
			return "";
		return group;
	}

	/**
	 * This is a method to handle simple validation for required fields and invalid values.
	 * @return If no validation error, returns null. If an error, returns a STring describing the error.
	 */
	@Override
	public String validate()
	{
		String retval = null;
		if (name == null)
		{
			retval = VALIDATE_FAILURE1;
			return retval;
		}
		
		if (name.trim().length() == 0)
		{
			retval = VALIDATE_FAILURE2;
		}
		return retval;
	}
}
