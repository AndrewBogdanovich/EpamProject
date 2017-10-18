package com.andrewbogdanovich.github.epamproject;

import com.andrewbogdanovich.github.epamproject.http.IHttpClient;
import com.andrewbogdanovich.github.epamproject.json.parsing.IUser;
import com.andrewbogdanovich.github.epamproject.json.parsing.IUserList;
import com.andrewbogdanovich.github.epamproject.json.parsing.UserParserFactory;
import com.andrewbogdanovich.github.epamproject.json.parsing.UsersListParserFactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.InputStream;

import mocks.Mocks;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(
        constants = BuildConfig.class,
        sdk = Constants.SDK_VERSION)

public class UserParserTest {
    private static final String SOURCE = "{\n" +
            "  \"id\" : 1,\n" +
            "  \"name\" : \"First Name and Last Name\",\n" +
            "  \"age\" : \"20\",\n" +
            "\"city\" : \"Example city\"\n" +
            "}";

    private static final int EXPECTED_ID = 1;
    private static final String EXPECTED_NAME = "First Name and Last Name";
    private static final int EXPECTED_AGE = 20;
    private static final String EXPECTED_CITY = "Example city";

    private IHttpClient mHttpClient;

    @Before
    public void setUp() {
        mHttpClient = mock(IHttpClient.class);
    }

    @Test
    public void parse() throws Exception {
        final UserParserFactory userParserFactory = new UserParserFactory();
        final IUser user = userParserFactory.createParser(SOURCE).parse();

        assertEquals(EXPECTED_ID, user.getId());
        assertEquals(EXPECTED_NAME, user.getName());
        assertEquals(EXPECTED_AGE, user.getAge());
        assertEquals(EXPECTED_CITY, user.getCity());
    }

    @Test
    public void parseUserListFromResource() throws Exception {
        InputStream mockedInputStream = Mocks.stream("user/user_list.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        InputStream response = mHttpClient.request("http://myBackend/getUserList");

        final UsersListParserFactory usersListParserFactory = new UsersListParserFactory();
        final IUserList userList = usersListParserFactory.createParser(response).parse();
        assertTrue(userList.getUserList().size() == 2);
        assertTrue(userList.getUserList().get(0).getId() == 1);
        Assert.assertEquals(userList.getUserList().get(0).getName(), "First Name and Last Name");

        InputStream mockedInputStreamWithObject = Mocks.stream("user/user_list_with_root_object.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStreamWithObject);
        InputStream responseWithObject = mHttpClient.request("http://myBackend/getUserListWithObject");

        final IUserList userListWithObject = usersListParserFactory.createParserForResponceWithObject(responseWithObject).parse();
        assertTrue(userListWithObject.getUserList().size() == 2);


    }

}
