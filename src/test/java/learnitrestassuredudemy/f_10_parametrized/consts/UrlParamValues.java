package learnitrestassuredudemy.f_10_parametrized.consts;

import java.util.Map;

public class UrlParamValues {

    public static final String BASE_URI = "https://api.trello.com/1";
    public static final String USERNAME = "miroslawdyduch";
    public static final String VALID_KEY = "6f04eeee897329faa9261fe2bca35a0b";
    public static final String VALID_TOKEN = "ATTA2b88bae9dfa84e8ac67cbc393c8b8468cda406428d9f3c3e43e5cd72765a2d6411212F83";
    public static final String EXISTING_BOARD_ID = "657d413256de270c186b014d";
    public static final String EXISTING_LIST_ID = "657d3e2859348b240137e17c";

    public static final Map<String, String> AUTH_QUERY_PARAMS = Map.of(
            "key", VALID_KEY,
            "token", VALID_TOKEN);

    public static final Map<String, String> ANOTHER_USER_AUTH_QUERY_PARAMS = Map.of(
            "key", "8b32218e6887516d17c84253faf967b6",
            "token", "492343b8106e7df3ebb7f01e219cbf32827c852a5f9e2b8f9ca296b1cc604955"
    );

    public static final Map<String, String> QUERY_PARAMS = Map.of(
            "fields", "id,name"
    );

    public static final Map<String, String> PATH_MEMBER_PARAMS = Map.of(
            "member", USERNAME
    );

    public static final Map<String, String> PATH_ID_BOARD = Map.of(
            "id", EXISTING_BOARD_ID
    );
}