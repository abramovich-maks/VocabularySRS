package com.vocabularysrs.infrastructure.dictionary.controller;

import lombok.Builder;

import java.util.List;

@Builder
public record AllGroupsResponse(
        List<GroupsResponse> groups
) {
}
