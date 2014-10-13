package com.homework.chat;

        import android.app.Fragment;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ListView;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by Yushchenko on 02.10.2014.
 */

public class ListActivity extends Fragment {
    String[] nickNames = { "good", "bad", "fiona", "Shrek", "muha", "spider",
            "SuperM", "cap", "vs", "skype", "listV", "good", "bad", "fiona",
            "Shrek", "muha", "spider", "SuperM", "cap", "vs", "skype", "listV"};

    private List<ChatContact> contactsList;
    private AdapterContact adapterContacts = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View listView = inflater.inflate(R.layout.contacts_list, null);

        return listView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        fillContactsList();

        adapterContacts = new AdapterContact(getActivity(), contactsList);
        ListView list = (ListView) getActivity().findViewById(R.id.contactListId);

        list.setAdapter(adapterContacts);

    }

    public void fillContactsList() {
        contactsList = new ArrayList<ChatContact>();

        for ( int i = 0; i < nickNames.length; i++ ) {
            contactsList.add(new ChatContact(nickNames[i]));
        }

        getActivity().setTitle(String.format("%d users",  nickNames.length));
        //getActivity().
    }
}
