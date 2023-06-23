package org.example.task1;

import org.example.task1.domain.CompanyInfo;
import org.example.task1.domain.ProfileInfo;
import org.example.task1.domain.UserInfo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Thread.sleep;

public class FirstTaskApplication {


    public ProfileInfo getProfileInfo(Long id) {
        ProfileInfo profileInfo = new ProfileInfo();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        try {
            Future<CompanyInfo> companyInfoFuture =
                    executorService.submit(() -> getCompanyInfo(id));
            Future<UserInfo> userInfoFuture =
                    executorService.submit(() -> getUserInfo(id));
            profileInfo.companyInfo = companyInfoFuture.get();
            profileInfo.userInfo = userInfoFuture.get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }

        return profileInfo;
    }

    private UserInfo getUserInfo(Long id) {
        try {
            sleep(900);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        UserInfo userInfo = new UserInfo();
        userInfo.name = id.toString();
        return userInfo;
    }

    private CompanyInfo getCompanyInfo(Long id) {
        try {
            sleep(900);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.id = id.toString();
        return companyInfo;
    }

}
