package net.matez.wildnature.data.setup;

public enum DataGenType {
    GEN_ONLY_NEW, /* generates only newly added blocks/items */
    GEN_REFRESH_ALL, /* generates all blocks/items overwriting old */
    GEN_DELETE_AND_REFRESH_ALL, /* cleanup. Deletes all and generates again. If some blocks were deleted use this */
    GEN_MISSING_TEXTURES, /* analyze block and item models and find textures that doesn't exists. Then put there dummy ones to let you know.*/
    REMOVE_OLD_TEXTURES /* remove old textures that don't have any use (now only missing) */
}
