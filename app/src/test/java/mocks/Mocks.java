package mocks;

import junit.framework.Assert;

import org.mockito.Mock;

import java.io.InputStream;

/**
 * Created by Tom on 17.10.2017.
 */

public class Mocks {

    public static InputStream stream(final String pName){
        final InputStream resourceAsStream = Mock.class.getClassLoader().getResourceAsStream(pName);
        Assert.assertNotNull("resource not found, maybe you forget add .json?", resourceAsStream);
        return resourceAsStream;
    }
}
