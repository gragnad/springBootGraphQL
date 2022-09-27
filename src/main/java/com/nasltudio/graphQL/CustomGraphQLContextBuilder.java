package com.nasltudio.graphQL;

import graphql.kickstart.execution.context.DefaultGraphQLContext;
import graphql.kickstart.execution.context.GraphQLKickstartContext;
import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.servlet.context.DefaultGraphQLServletContextBuilder;
import graphql.kickstart.servlet.context.DefaultGraphQLWebSocketContext;
import graphql.kickstart.servlet.context.GraphQLServletContextBuilder;
import graphql.kickstart.spring.webflux.DefaultGraphQLSpringWebSocketSessionContext;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import javax.websocket.server.HandshakeRequest;

public class CustomGraphQLContextBuilder implements GraphQLServletContextBuilder {

    private final DataLoader userdataLoader;

    public CustomGraphQLContextBuilder(DataLoader userdataLoader) {
        this.userdataLoader = userdataLoader;
    }

    @Override
    public GraphQLKickstartContext build() {
        return new DefaultGraphQLContext();
    }

    @Override
    public GraphQLKickstartContext build(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return DefaultGraphQLServletContext.createServletContext()
                .with(httpServletRequest)
                .with(httpServletResponse)
                .with(buildDataLoaderRegistry())
                .build();
    }

    @Override
    public GraphQLKickstartContext build(Session session, HandshakeRequest handshakeRequest) {
        return DefaultGraphQLWebSocketContext.createWebSocketContext()
                .with(session)
                .with(handshakeRequest)
                .with(buildDataLoaderRegistry())
                .build();
    }

    private DataLoaderRegistry buildDataLoaderRegistry() {
        DataLoaderRegistry registry = new DataLoaderRegistry();
        registry.register("userDataLoader", userdataLoader);
        return registry;
    }
}
