package com.etiya.darwinproject1.repositories.abstracts.user;

import com.etiya.darwinproject1.business.dtos.response.user.UserInfoResponse;
import com.etiya.darwinproject1.business.dtos.response.user.UserLoginResponse;
import com.etiya.darwinproject1.entities.concretes.user.UserSpec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDao extends JpaRepository<UserSpec, Long> {

    @Query(value = "select new com.etiya.darwinproject1.business.dtos.response.user" +
            ".UserInfoResponse(us.id, gT.name, us.uname, gT.isActv) from UserSpec us join GnlTp gT on gT.id = us.gnlTp.id " +
            "where gT.name =:name " )
    List<UserInfoResponse> inquireUserTypes(String name);

    @Query(value = "select new com.etiya.darwinproject1.business.dtos.response.user" +
            ".UserLoginResponse(us.id, gT.name, us.uname, gS.isActv) from UserSpec us join us.gnlTp gT join us.gnlSt gS " +
            "where (us.uname = :uname) " +
            "and (us.pwd = :pwd) ")
    UserLoginResponse inquireUser(String uname, String pwd);

    UserSpec findByUname (String uname);

    @Query("select u from UserSpec u where u.id=:userId")
    UserSpec isAdmin (Long userId);

    boolean existsUserById(Long userId);

    @Query("select u from ProdOfr po join po.custOrdItems coi join coi.custOrd co join co.userSpec u join u.gnlSt st join u.gnlTp tp " +
            "where co.id =:selectedOfferId")
    UserSpec getSelectedOfferUser(Long selectedOfferId);

    @Query("select u from ProdOfr po join po.custOrdItems coi join coi.custOrd co join co.userSpec u join u.gnlSt st join u.gnlTp tp " +
            "where co.id =:selectedOfferId")
    UserSpec findBySelectedOfferId(Long selectedOfferId);

}
