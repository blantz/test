package common.objects;

import org.junit.*;

import common.objects.Authenticator;
import common.objects.Permission;

import static org.junit.Assert.*;

public class TestPermission
{
	@Test
	public void testPermission()
	{
		Permission perm = new Permission();
		assertEquals ("Name not blank", "", perm.name);
		perm = new Permission (Authenticator.SYSTEM_USER);
		assertEquals ("Name not valid", Authenticator.SYSTEM_USER, perm.name);
	}
	
	@Test
	public void testGetName()
	{
		Permission perm = new Permission();
		perm.name = null;
		assertEquals ("Name not blank", "", perm.getName());
		perm = new Permission (Authenticator.SYSTEM_USER);
		assertEquals ("Name not valid", Authenticator.SYSTEM_USER, perm.getName());
	}
	
	@Test
	public void testSetName()
	{
		Permission perm = new Permission();
		perm.setName(Authenticator.SYSTEM_USER);
		assertEquals ("Name not valid", Authenticator.SYSTEM_USER, perm.getName());
	}
	
	@Test
	public void testValidate()
	{
		Permission perm = new Permission();
		assertEquals ("Blank name not found", Permission.VALIDATE_FAILURE2, perm.validate());
		perm.name = null;
		assertEquals ("Null name not found", Permission.VALIDATE_FAILURE1, perm.validate());
		perm.name = Authenticator.SYSTEM_USER;
		assertNull ("Valid name not found", perm.validate());
	}
}
