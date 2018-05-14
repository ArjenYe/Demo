package com.example.yeajie.app.original.autocall.recyclercall.presenter;

import com.example.yeajie.app.original.autocall.recyclercall.api.RecyclerDialView;
import com.example.platform.local.DialEntity;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * @author arjen
 */

public class RecyclerDialPresenterImpl implements RecyclerDialPresenter {
    private RecyclerDialView dialView;

    public RecyclerDialPresenterImpl(RecyclerDialView dialView) {
        this.dialView = dialView;
    }

    @Override
    public void loadContact() {
        List<DialEntity> dialEntities = DataSupport.findAll(DialEntity.class);
//        if (CollectionUtil.isNullOrEmpty(dialEntities)) {
//            dialEntities = DialContactEntry.getInstance().addContacts().getDialEntities();
//        }
        dialView.refreshContacts(dialEntities);
    }
}
