package com.sap.trial.firstms.test.repository;

import com.sap.trial.firstms.test.entity.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class AdvertisementRepository extends JdbcDaoSupport implements AdvertisementDAO{

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public List<Advertisement> getAllAdvertisements() {
        String sql = "SELECT * FROM advertisement";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Advertisement> result = new ArrayList<Advertisement>();
        for (Map<String, Object> row : rows) {
            Advertisement ad = new Advertisement();
            ad.setId((Long) row.get("id"));
            ad.setTitle((String) row.get("title"));
            result.add(ad);
        }

        return result;
    }

    @Override
    public Advertisement getAdvertisement(long id) {
        String sql = "SELECT * FROM advertisement WHERE id = ?";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql, id);

        Advertisement result = new Advertisement();
        for (Map<String, Object> row : rows) {
            result.setId((Long) row.get("id"));
            result.setTitle((String) row.get("title"));
        }

        return result;
    }


    public void addAdvertisement(Advertisement ad) {
        String sql = "INSERT INTO advertisement (id, title) VALUES (?, ?)";
        getJdbcTemplate().update(sql,ad.getId(), ad.getTitle());
    }

    public void updateAdvertisement(Advertisement ad) {
        String sql = "UPDATE advertisement SET title = ? WHERE id = ?";
        getJdbcTemplate().update(sql, ad.getTitle(), ad.getId());
    }

    @Override
    public void deleteAdvertisement(long id) {
        String sql = "DELETE FROM advertisement WHERE id = ?";
        getJdbcTemplate().update(sql, id);
    }

}
